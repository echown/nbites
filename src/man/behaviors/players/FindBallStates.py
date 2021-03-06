import ChaseBallConstants as constants
import ChaseBallTransitions as transitions
from ..navigator import Navigator
from ..util import *
from objects import Location
from math import fabs, degrees

# TODO this should be super state, as written, easy to introduce bugs
@superState('gameControllerResponder')
def findBall(player):
    """
    Decides what type of search to do.
    """
    if player.firstFrame():
        player.inKickingState = False
        player.claimedBall = False

        distance = player.brain.ball.distance
        if distance > constants.FAR_BALL_SEARCH_DIST:
            return player.goNow('playOffBall')
            
        bearing = fabs(degrees(player.brain.ball.bearing))
        if distance <= constants.SCRUM_DIST and bearing < constants.SPIN_SEARCH_BEARING:
            return player.goNow('scrumStrategy')
        else:
            return player.goNow('spinSearch')

@superState('gameControllerResponder')
@stay
@ifSwitchLater(transitions.spunOnce, 'playOffBall')
@ifSwitchLater(transitions.shouldChaseBall, 'spinToFoundBall')
def spinSearch(player):
    """
    spins and looks to the direction where the ball is thought to be
    """
    if player.firstFrame():
        my = player.brain.loc
        ball = Location(player.brain.ball.x, player.brain.ball.y)
        spinDir = my.spinDirToPoint(ball)
        player.setWalk(0, 0, spinDir*Navigator.QUICK_SPEED)
        player.brain.tracker.lookToSpinDirection(spinDir)

@superState('gameControllerResponder')
@stay
def searchAfterFall(player):
    """
    goes into this state only if we saw the ball during the last second before the fall
    """
    if player.firstFrame():
        player.brain.tracker.trackBall()

    if player.brain.motion.calibrated:
        if player.brain.ball.vis.on:
            return player.goNow('playOffBall')
        else:
            return player.goNow('spinSearch')
    else:
        return player.stay()

@superState('gameControllerResponder')
@stay
@ifSwitchLater(transitions.shouldFindBall, 'findBall')
def spinToFoundBall(player):
    """
    spins to the ball until it is facing the ball 
    """
    if player.brain.nav.dodging:
        return player.stay()

    if player.firstFrame():
        player.brain.tracker.trackBall()
        print "spinning to found ball"

    theta = degrees(player.brain.ball.bearing)
    spinToFoundBall.isFacingBall = (fabs(theta) <= constants.FACING_BALL_ACCEPTABLE_BEARING)

    if spinToFoundBall.isFacingBall:
        print "facing ball"
        return player.goLater('playOffBall')

    # spins the appropriate direction
    if theta < 0.:
        player.brain.nav.walk(0., 0., -1*constants.FIND_BALL_SPIN_SPEED)
    else:
        player.brain.nav.walk(0., 0., constants.FIND_BALL_SPIN_SPEED)

@defaultState('backPedal')
@superState('gameControllerResponder')
@ifSwitchLater(transitions.shouldChaseBall, 'spinToFoundBall')
def scrumStrategy(player):
    """
    super state of the strategy to search for balls lost in front of robot
    """
    pass

@superState('scrumStrategy')
@stay
def backPedal(player):
    if player.firstFrame():
        player.setWalk(constants.BACK_PEDAL_SPEED, 0., 0.)
        player.brain.tracker.repeatFastNarrowPan()

    elif player.stateTime > constants.BACK_PEDAL_TIME:
        return player.goLater('spinSearch')

@superState('scrumStrategy')
@stay
def spinForwardSearch(player):
    if player.firstFrame():
        my = player.brain.loc
        ball = Location(player.brain.ball.x, player.brain.ball.y)
        spinDir = my.spinDirToPoint(ball)
        X = constants.FRONT_SPIN_SEARCH_SPEED_X
        Y = constants.FRONT_SPIN_SEARCH_SPEED_Y
        H = constants.FRONT_SPIN_SEARCH_SPEED_H
        player.setWalk(X, Y*spinDir, H*spinDir)
        player.brain.tracker.lookToAngle(spinDir*constants.FRONT_SPIN_LOOK_TO_ANGLE)
    if transitions.spunOnce(player):
        return player.goLater('playOffBall')

@defaultState('walkToBallModel')
@superState('gameControllerResponder')
@ifSwitchLater(transitions.shouldChaseBall, 'spinToFoundBall')
def farBallSearch(player):
    pass

#TODO consts
@superState('farBallSearch')
@stay
def walkToBallModel(player):
    if player.firstFrame():
        player.brain.nav.chaseBall(Navigator.FAST_SPEED, fast = True)
        player.brain.tracker.repeatFastNarrowPan()
    elif player.stateTime > 5:
        return player.goLater('spinSearch')
