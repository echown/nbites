package nbtool.util;

import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nbtool.data.Log;

public class NBConstants {
	
	public static final int VERSION = 6;
	
	public static final String PROTOBUF_TYPE_PREFIX = "proto-";
	
	public static final Rectangle DEFAULT_BOUNDS = new Rectangle(0,0,900,600);
	
	public static final String USER_CLASS_EXCEPTIONS = "~/.nbtool-exceptions.properties";
	public static final String USER_LOG_TO_VIEW_MAP = "~/.nbtool-views.properties";
	
	public static final String DEFAULT_S = "PT_default";
	public static final String PROTOBUF_S = "PT_protobuf";

	public static final String IMAGE_S = "YUVImage";
	public static final String STATS_S = "stats";
	
	public static final int STREAM_PORT = 30000;
	public static final int CONTROL_PORT = 30001;
	public static final int NBCROSS_PORT = 30002;
	
	public static final int SOCKET_TIMEOUT = 5000; 		//Milliseconds
	public static final int NBCROSS_CALL_TIMEOUT = 0;	//interpreted as infinite.  Note, since these calls are local
														//we worry less about dead sockets.
	
	//Who names a class DataFlavor?  That's just so... Idk. Fllaavvvooorr.  Data Fllaaavoor. MMM, gimme some'o that DataFlav
	public static DataFlavor treeFlavor = new DataFlavor(Log.class, "NB-OpaqueLog");
	
	public static enum MODE {
		NETWORK_SAVING(0), NETWORK_NOSAVE(1), FILESYSTEM(2), NONE(3);
		
		public final int index;
		private MODE(final int i) {
			this.index = i;
		}
	}
	
	public static final String[] MODE_STRINGS = {
		"from net to fs", "from net", "from fs", "none"
	};
	
	public static enum STATUS {
		IDLE(0),		//No io or IO threads active.  No active SessionHandler.  Ready to start.
		STARTING(1),	//Setting up IO or threads in a SessionHandler (usually very short)
		RUNNING(2),		//IO or threads active, in a SessionHandler
		STOPPING(3);	//IO or threads still active but shutting down.  When the SessionHandler determines 
						//all activity has stopped, it will notify idle.
		
		public final int index;
		private STATUS(int i) {
			this.index = i;
		}
	}
	
	public static final String[] STATUS_STRINGS = {
		"idle", "starting", "running", "stopping"
	};
}
