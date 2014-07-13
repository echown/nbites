import SharedTransitions as shared
import PlayOffBallTransitions as transitions
import RoleConstants as role
import ChaseBallTransitions as chase
import ChaseBallConstants as chaseConstants
import ClaimTransitions as claims
from SupporterConstants import getSupporterPosition, CHASER_DISTANCE
import noggin_constants as NogginConstants
from ..navigator import Navigator as nav
from objects import Location, RobotLocation
from ..util import *
from math import hypot, fabs
import random

@defaultState('branchOnRole')
@superState('gameControllerResponder')
@ifSwitchNow(transitions.shouldBeSupporter, 'positionAsSupporter')
@ifSwitchNow(transitions.shouldApproachBall, 'approachBall')
def playOffBall(player):
    """
    Superstate for all off ball play.
    """
    player.inKickingState = False

@superState('playOffBall')
def branchOnRole(player):
    """
    Chasers have different behavior than defenders, so we branch on
    role here.
    """
    if role.isChaser(player.role):
        if transitions.shouldFindSharedBall(player):
            return player.goNow('searchFieldForSharedBall')
        return player.goNow('searchFieldByQuad')
    return player.goNow('positionAtHome')

@superState('playOffBall')
@stay
@ifSwitchNow(shared.navAtPosition, 'watchForBall')
def positionAtHome(player):
    """
    Go to the player's home position
    If ball-chasing conditions are met it will exit and go to chase
    """
    if player.firstFrame():
        player.brain.tracker.trackBall()

    player.brain.nav.goTo(player.homePosition, precision = nav.PLAYBOOK,
                          speed = nav.QUICK_SPEED, avoidObstacles = True,
                          fast = False, pb = False)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.tooFarFromHome(20), 'positionAtHome')
def watchForBall(player):
    """
    The player is at home, waiting for the ball to be within it's box (range)
    """
    if player.firstFrame():
        player.brain.nav.stand()

@superState('playOffBall')
@stay
@ifSwitchLater(shared.ballOffForNFrames(60), 'findBall')
def positionAsSupporter(player):
    if (role.isChaser(player.role) and player.brain.ball.distance > 
        hypot(CHASER_DISTANCE, CHASER_DISTANCE)):
        fast = True
    else:
        fast = False

    positionAsSupporter.position = getSupporterPosition(player, player.role)
    player.brain.nav.goTo(positionAsSupporter.position, precision = nav.GENERAL_AREA,
                          speed = nav.QUICK_SPEED, avoidObstacles = True,
                          fast = False, pb = False)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.shouldFindFlippedSharedBall, 'searchFieldForFlippedSharedBall')
@ifSwitchNow(transitions.shouldStopLookingForSharedBall, 'searchFieldByQuad')
def searchFieldForSharedBall(player):
    """
    Searches the field for the shared ball.
    """
    if player.firstFrame():
        player.brain.tracker.trackBall()
        player.sharedBallCloseCount = 0
        player.sharedBallOffCount = 0

    sharedball = Location(player.brain.sharedBall.x, player.brain.sharedBall.y)
    player.brain.nav.goTo(sharedball, precision = nav.GENERAL_AREA,
                          speed = nav.QUICK_SPEED, avoidObstacles = True,
                          fast = True, pb = False)

    if sharedball.distTo(player.brain.loc) < 100:
        player.sharedBallCloseCount += 1
    else:
        player.sharedBallCloseCount = 0

    if not transitions.shouldFindSharedBall(player):
        player.sharedBallOffCount += 1
    else:
        player.sharedBallOffCount = 0

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.shouldStopLookingForFlippedSharedBall, 'searchFieldByQuad')
def searchFieldForFlippedSharedBall(player):
    """
    Flips the shared ball and searches for it.
    """
    if player.firstFrame():
        player.brain.tracker.trackBall()
        player.sharedBallCloseCount = 0

    sharedball = Location(-1*(player.brain.sharedBall.x-NogginConstants.MIDFIELD_X) + NogginConstants.MIDFIELD_X,
                          -1*(player.brain.sharedBall.y-NogginConstants.MIDFIELD_Y) + NogginConstants.MIDFIELD_Y)
    player.brain.nav.goTo(sharedball, precision = nav.GENERAL_AREA,
                          speed = nav.QUICK_SPEED, avoidObstacles = True,
                          fast = True, pb = False)

    if sharedball.distTo(player.brain.loc) < 100:
        player.sharedBallCloseCount += 1
    else:
        player.sharedBallCloseCount = 0

    if not transitions.shouldFindSharedBall(player):
        player.sharedBallOffCount += 1
    else:
        player.sharedBallOffCount = 0

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.shouldFindSharedBall, 'searchFieldForSharedBall')
def searchFieldByQuad(player):
    """
    Search the field quadrant by quadrant. Choose first quadrant by loc heading.
    """
    if player.firstFrame():
        player.brain.tracker.trackBall()
        searchFieldByQuad.dest = min(points, key=lambda x:fabs(player.brain.loc.getRelativeBearing(x)))

    if shared.navAtPosition(player):
        if searchFieldByQuad.dest == quad1Center:
            searchFieldByQuad.dest = quad2Center
        elif searchFieldByQuad.dest == quad3Center:
            searchFieldByQuad.dest = quad1Center
        elif searchFieldByQuad.dest == quad2Center:
            searchFieldByQuad.dest = quad4Center
        elif searchFieldByQuad.dest == quad4Center:
            searchFieldByQuad.dest = quad3Center

    player.brain.nav.goTo(searchFieldByQuad.dest, precision = nav.GRAINY,
                          speed = nav.QUICK_SPEED, avoidObstacles = True,
                          fast = True, pb = False)

quad1Center = Location(NogginConstants.CENTER_FIELD_X * .6, NogginConstants.CENTER_FIELD_Y * .6)
quad2Center = Location(NogginConstants.CENTER_FIELD_X * .6, NogginConstants.CENTER_FIELD_Y * 1.4)
quad3Center = Location(NogginConstants.CENTER_FIELD_X * 1.4, NogginConstants.CENTER_FIELD_Y * 1.4)
quad4Center = Location(NogginConstants.CENTER_FIELD_X * 1.4, NogginConstants.CENTER_FIELD_Y * .6)
points = [quad1Center, quad2Center, quad3Center, quad4Center]
