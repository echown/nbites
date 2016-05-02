//
//  Network.cpp
//  tool8-separatesex
//
//  Created by Philip Koch on 4/6/16.
//

#include "Network.hpp"
#include "Control.hpp"

#include <unistd.h>

#include <exception>

#define NBL_LOGGING_LEVEL NBL_INFO_LEVEL

namespace nblog {
    namespace network {

        SocketMaster::SocketMaster(int port) :
            server(-1), client(-1), clientIndex(0), connected(false)
        {

            io::ioret ret = io::server_socket(server, port, 0);

            if (ret) {
                std::string err = utilities::get_error(errno);
                NBL_ERROR("SocketMaster(port=%d) got ERROR: %s",
                          port,
                          err.c_str());

                throw std::runtime_error("SocketMaster could not create server socket");
            }

            pthread_mutex_init(&connectionMutex, NULL);
            pthread_cond_init(&connectionAvailableCond, NULL);
            pthread_cond_init(&connectionDiedCond, NULL);
        }

        void SocketMaster::threadLoop() {

            NBL_WARN("SocketMaster::threadLoop() starting...");


            for (;running;) {
                NBL_WARN("SocketMaster::threadLoop() polling for client (index was %zu)", clientIndex)
                connected = false;
                io::client_socket_t temp;
                io::ioret ret = io::poll_accept(server, temp);
                if (ret) {
                    std::string err = utilities::get_error(errno);
                    NBL_ERROR("SocketMaster() got ERROR: %s",
                              err.c_str());

                    throw std::runtime_error("SocketMaster could not poll for client");
                }

                pthread_mutex_lock(&connectionMutex);
                ++clientIndex;
                client = temp;
                connected = true;
                pthread_cond_broadcast(&connectionAvailableCond);

                for (;;) {
                    pthread_cond_wait(&connectionDiedCond, &connectionMutex);
                    if (!connected) { break;
                        NBL_WARN("SocketMaster::threadLoop() found connection died (index is %zu)", clientIndex);
                    } else {
                        NBL_ERROR("SocketMaster::threadLoop() was signalled connectionDied but found (connected) for index %zu!", clientIndex);
                    }
                }

                pthread_mutex_unlock(&connectionMutex);
            }

            NBL_PRINT("SocketMaster::threadLoop() returning.");
        }

        void SocketMaster::blockForClient(io::client_socket_t &sock, size_t &index) {
            pthread_mutex_lock(&connectionMutex);

            for (;;) {
                if (connected) {
                    sock = client;
                    index = clientIndex;

                    pthread_mutex_unlock(&connectionMutex);

                    NBL_WARN("SocketMaster::blockForClient() returning sock=%d client=%zu", sock, index);
                    return;
                }

                pthread_cond_wait(&connectionAvailableCond, &connectionMutex);
            }
        }

        bool SocketMaster::checkClient(size_t checkIndex) {
            pthread_mutex_lock(&connectionMutex);
            NBL_ASSERT_GE(clientIndex, checkIndex)

            bool ret = (connected && clientIndex == checkIndex);
            pthread_mutex_unlock(&connectionMutex);
            return ret;
        }

        void SocketMaster::flagClient(size_t flagIndex) {
            pthread_mutex_lock(&connectionMutex);
            if ( connected && clientIndex == flagIndex ) {
                connected = false;
                pthread_cond_broadcast(&connectionDiedCond);
            }

            pthread_mutex_unlock(&connectionMutex);
        }

        void SocketMaster::forceClose() {
            NBL_PRINT("SocketMaster::forceClose()...");

            std::string errors;
            int ret;
            pthread_mutex_lock(&connectionMutex);

            if (client) {
                ret = close(client);
                errors += "\tclient socket: " + (ret ? utilities::get_error(errno) : "SUCCESS") + "\n";
            }

            if (server) {
                ret = close(server);
                errors += "\tserver socket: " + (ret ? utilities::get_error(errno) : "SUCCESS") + "\n";
            }

            connected = false;
            pthread_cond_broadcast(&connectionDiedCond);
            pthread_mutex_unlock(&connectionMutex);

            NBL_PRINT("SocketMaster::forceClose() got:\n%s", errors.c_str());
        }

        void Streamer::threadLoop() {

            NBL_WARN("Controller::threadLoop() starting...");

            qorder normal = {Q_CONTROL, Q_STREAM};
            qorder no_stream = {Q_CONTROL};

            for (;running;) {
                if (socket > 0 && master.checkClient(clientIndex)) {
                    ++index;

                    qorder& oref = control::check(control::flags::logToStream) ? normal : no_stream;

                    logptr tosend = provider.blockForLog(oref, io::IO_MAX_DELAY() / 2);
                    io::ioret iret;

                    if (tosend) {
                        iret = tosend->send(socket);
                    } else {
                        NBL_INFO("Streamer::threadLoop() pinging client: %zu",
                                 clientIndex)
                        ping->createdWhen = index;
                        iret = ping->send(socket);;
                    }

                    if (iret) {
                        NBL_WARN("Streamer::threadLoop() failed to send log to client: %zu", clientIndex);
                        master.flagClient(clientIndex);
                    }

                } else {
                    master.blockForClient(socket, clientIndex);
                }
            }

             NBL_PRINT("Streamer::threadLoop() returning.");
        }

        void Controller::threadLoop() {

            NBL_WARN("Controller::threadLoop() starting...");


            for (;running;) {
                if (socket > 0 && master.checkClient(clientIndex)) {

                    logptr recvd = Log::recv(socket);

                    if (recvd) {
                        NBL_INFO( "Controller::threadLoop() got log of type: %s", recvd->logClass.c_str());
                        consumer.consumeLog(recvd);
                    } else {
                        NBL_WARN( "Controller::threadLoop() failed to read client: %zu", clientIndex);

                        master.flagClient(clientIndex);
                    }

                } else {
                    master.blockForClient(socket, clientIndex);
                }
            }

             NBL_PRINT("Controller::threadLoop() returning.");
        }
    }
}

















