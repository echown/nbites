from ..navigator import BrunswickSpeeds as speeds

MAX_X_SPEED = speeds.MAX_X_MAGNITUDE
MAX_Y_SPEED = speeds.MAX_Y_MAGNITUDE
MAX_SPIN_SPEED = speeds.MAX_SPIN_MAGNITUDE

# Component Switches
USE_LOC_CHASE = True
USE_DRIBBLE = False

# Transitions' Constants
# Ball on and off frame thresholds
BALL_ON_THRESH = 2
BALL_OFF_THRESH = 30
BALL_OFF_KICK_THRESH = 80
BALL_OFF_ACTIVE_LOC_THRESH = 200
# Value to stop spinning to ball and approach
BALL_APPROACH_BEARING_THRESH = 30
# Value to start spinning to ball
BALL_APPROACH_BEARING_OFF_THRESH = 40

# Should position for kick
BALL_PFK_BEARING_THRESH = 15
BALL_PFK_LEFT_Y = 16.0
BALL_PFK_RIGHT_Y = -BALL_PFK_LEFT_Y
BALL_PFK_MAX_X = 75
BALL_PFK_MIN_X = 16

# Should spin to kick
SHOULD_SPIN_TO_KICK_X = 10.5
SHOULD_SPIN_TO_KICK_Y = 7
SHOULD_SPIN_TO_KICK_DIST = 40

# PFK (relates to navigator/PFKStates.py)
KICK_CLOSE_ENOUGH_X = 2.7
KICK_CLOSE_ENOUGH_Y = 2.7

# Should dribble should and should stop dribbling
SHOULD_DRIBBLE_X = BALL_PFK_MAX_X
SHOULD_DRIBBLE_Y = BALL_PFK_LEFT_Y
SHOULD_DRIBBLE_BEARING = 30.0
STOP_DRIBBLE_X = SHOULD_DRIBBLE_X + 20
STOP_DRIBBLE_Y = SHOULD_DRIBBLE_Y + 20
STOP_DRIBBLE_BEARING = 40.0

# States' constants
# turnToBall
FIND_BALL_SPIN_SPEED = speeds.MAX_SPIN_MAGNITUDE
BALL_SPIN_SPEED = speeds.MAX_SPIN_MAGNITUDE
BALL_SPIN_GAIN = 0.9
MIN_BALL_SPIN_MAGNITUDE = speeds.MIN_SPIN_MAGNITUDE

# approachBall() values
APPROACH_X_GAIN = 0.1
APPROACH_SPIN_SPEED = speeds.MAX_SPIN_WHILE_X_MAGNITUDE
MIN_APPROACH_SPIN_MAGNITUDE = speeds.MIN_SPIN_MAGNITUDE
APPROACH_SPIN_GAIN = 1
MAX_APPROACH_X_SPEED = speeds.FWD_MAX_SPEED
MIN_APPROACH_X_SPEED = speeds.FWD_MIN_SPEED

# approachBallWithLoc() values
IN_FRONT_SLOPE = 5.6
APPROACH_DIST_TO_BALL = 25
APPROACH_NO_LOC_THRESH = 4
APPROACH_NO_MORE_LOC_DIST = 150
APPROACH_OMNI_DIST = 25
APPROACH_ACTIVE_LOC_DIST = 60
APPROACH_ACTIVE_LOC_BEARING = 60

# shouldKick()
SHOULD_STOP_DIST = 60
SHOULD_START_DIST = 40
SHOULD_STOP_Y = BALL_PFK_LEFT_Y
SHOULD_KICK_CLOSE_X = 10
SHOULD_KICK_FAR_X = 16
SHOULD_KICK_Y = 9

TURN_LEFT = 1
TURN_RIGHT = -1

CHASE_AFTER_KICK_FRAMES = 100

# find ball
WALK_FIND_BALL_FRAMES_THRESH = 720
SCAN_FIND_BEARING_THRESH = 50
SCAN_FIND_DIST_THRESH = 40

# Orbit ball
ORBIT_BALL_STEP_FRAMES = 150
ORBIT_OFFSET_DIST = 35          # from the ball to the center of the body
ORBIT_STEP_ANGLE = 15
ORBIT_Y_GAIN = .3
ORBIT_X_GAIN = .15
ORBIT_SPIN_GAIN = 0.7
STOP_ORBIT_BEARING_THRESH = 30.0
STOP_ORBIT_BALL_DIST = 50.0

MAX_LEFT_ORBIT_SPEED = speeds.OMNI_LEFT_MAX_SPEED
MAX_RIGHT_ORBIT_Y_SPEED = speeds.OMNI_RIGHT_MAX_SPEED
MIN_ORBIT_Y_MAGNITUDE = speeds.MIN_OMNI_Y_MAGNITUDE
MAX_FWD_ORBIT_X_SPEED = speeds.OMNI_FWD_MAX_SPEED
MAX_REV_ORBIT_X_SPEED = speeds.OMNI_REV_MAX_SPEED
MAX_LEFT_SPIN_X_ORBIT_SPEED = speeds.LEFT_SPIN_WHILE_X_MAX_SPEED
MAX_RIGHT_SPIN_X_ORBIT_SPEED = speeds.RIGHT_SPIN_WHILE_X_MAX_SPEED

STOP_PENALTY_DRIBBLE_COUNT = 120
