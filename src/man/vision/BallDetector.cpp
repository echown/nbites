
#include "BallDetector.h"

#include <algorithm>
#include <iostream>


using std::to_string;

namespace man {
namespace vision {

	BallDetector::BallDetector(FieldHomography* homography_,
							   Field* field_, bool topCamera_):
		blobber(),
        blobber2(),
		homography(homography_),
		field(field_),
		topCamera(topCamera_)
	{
        // Note from Chown:  I don't know what these numbers mean,
        // they are holdovers from the Dan Zeller days
		blobber.secondThreshold(115);
		blobber.minWeight(4);
		blobber2.secondThreshold(115);
		blobber2.minWeight(4);
	}

	BallDetector::~BallDetector() { }

	void BallDetector::setDebugImage(DebugImage * di) {
		debugDraw =  *di;
	}

    /* This function takes in a blob generated by the blobbing
       system running on the black image and determines if the
       blob could reasonably be interpreted at one of the black
       hexagons on a ball. The standard of proof is not particularly
       high - it should be of the right relative size. If it is
       ok, then add it to the current list of such blobs for later
       processing.
     */
    void BallDetector::filterBlackBlobs(Blob currentBlob,
                                        std::vector<std::pair<int,int>> & blobs)
    {
        int MAXBLACKBLOB = 8;
        float MINBLACKAREA = 10.0f;

        int centerX = static_cast<int>(currentBlob.centerX());
        int centerY = static_cast<int>(currentBlob.centerY());
        int principalLength = static_cast<int>(currentBlob.firstPrincipalLength());
        int principalLength2 = static_cast<int>(currentBlob.secondPrincipalLength());
        int minSecond = 1;
        // in principle the bottom camera might use a different standard
        // but for now we don't actally do this
        if (!topCamera) {
            minSecond = 1;
        }
        if (principalLength < MAXBLACKBLOB &&
            principalLength2 >= minSecond && currentBlob.area() > MINBLACKAREA &&
            (centerY > field->horizonAt(centerX) || !topCamera)) {
            blobs.push_back(std::make_pair(centerX, centerY));
            if (debugBall) {
                debugDraw.drawPoint(centerX, centerY, BLUE);
                std::cout << "Black blob " << centerX << " " << centerY <<
                    " " << principalLength << " " << principalLength2;
                }
        }
    }

    /* This function takes in a white blob generated by the blobbing
       system and determines if it might be the ball. Most such blobs
       are going to be the wrong size (generally too big), but if they
       aren't, then we look to see if the blob contains any internal
       black blobs. If we have enough such blobs then it is a pretty
       good bet that this is a ball.
     */
    int BallDetector::filterWhiteBlobs(Blob currentBlob,
                                        std::vector<std::pair<int,int>> & blobs,
                                        std::vector<std::pair<int,int>> blackBlobs)
    {
        int MAXWHITEBLOB = 40;
        float MINWHITEAREA = 10.0f;
        int centerX = static_cast<int>(currentBlob.centerX());
        int centerY = static_cast<int>(currentBlob.centerY());
        int principalLength = static_cast<int>(currentBlob.firstPrincipalLength());
        int principalLength2 = static_cast<int>(currentBlob.secondPrincipalLength());
        int minSecond = 3;
        if (!topCamera) {
            minSecond = 3;
        }

        // see if the blob is of the right general shape for a ball
        if (principalLength < MAXWHITEBLOB &&
            principalLength2 >= minSecond &&
            principalLength < principalLength2 * 2 &&
            currentBlob.area() > MINWHITEAREA &&
            (centerY > field->horizonAt(centerX) || !topCamera)) {
            blobs.push_back(std::make_pair(centerX, centerY));
            if (debugBall) {
                debugDraw.drawPoint(centerX, centerY, BLUE);
                std::cout << "White blob " << centerX << " " << centerY <<
                    " " << principalLength << " " << principalLength2 << std::endl;
            }
            int count = 0;
            // now loop through the black blobs and see if they are inside
            for (std::pair<int,int> p : blackBlobs) {
                if (abs(p.first - centerX) < principalLength &&
                    abs(p.second - centerY) < principalLength) {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

    /* Our worst ball detector. Tries to find small white blobs
       off in the distance. The trouble is that such blobs might
       be other things. This will require a number of sanity checks.
     */
    bool BallDetector::lookForFarAwayBalls(Blob blob)
    {
        int FARAWAYWHITESIZE = 15;
        float MINWHITEAREA = 10.0f;
        int centerX = static_cast<int>(blob.centerX());
        int centerY = static_cast<int>(blob.centerY());
        int principalLength = static_cast<int>(blob.firstPrincipalLength());
        int principalLength2 = static_cast<int>(blob.secondPrincipalLength());
        if (topCamera && centerY < height / 2 &&
            principalLength < FARAWAYWHITESIZE &&
            principalLength2 > principalLength / 2 &&
            blob.area() > MINWHITEAREA &&
            principalLength2 >= 1 &&
            (centerY > field->horizonAt(centerX) || !topCamera)) {
            return true;
        }
        return false;
    }

    /* Sometimes our balls are not tidy blobs (e.g. they are up against a
       post or a robot). So we need other methods of finding them. This
       is one such method. It looks at our filtered list of black blobs
       and tries to find groups of them that are near each other. If there
       are enough of them then it is strong evidence of a ball.
     */
    bool BallDetector::findCorrelatedBlackBlobs(std::vector<std::pair<int,int>> & blackBlobs,
                                                double cameraHeight, bool foundBall)
    {
        // loop through the filtered blobs and see if any are close together
        int TOPCAMERABLOBNEARNESS = 30;
        int BOTTOMCAMERABLOBNEARNESS = 20;
        int correlations[blackBlobs.size()];
        int count = 0;
        int closeness = TOPCAMERABLOBNEARNESS;
        if (!topCamera) {
            closeness = BOTTOMCAMERABLOBNEARNESS;
        }
        // loop through filtered black blobs
        for (std::pair<int,int> p : blackBlobs) {
            correlations[count] = 0;
            std::pair<int,int> pair1;
            // we're going to check against all other black blobs
            for (std::pair<int,int> q : blackBlobs) {
                int xdiff = abs(p.first - q.first);
                int ydiff = abs(p.second - q.second);
                if (xdiff < closeness && ydiff < closeness &&
                    (xdiff + ydiff) < 40 &&
                    (xdiff > 0 || ydiff > 0)) {
                    std::cout << "Closeness " << xdiff << " " <<
                        ydiff << " " << (xdiff + ydiff) << std::endl;
                    // could be correlated, watch out for shadows, robot parts, etc.
                    correlations[count] += 1;
                    if (correlations[count] > 1) {
                        if (debugBall) {
                            int midx = (pair1.first + q.first + p.first) / 3;
                            int midy = (pair1.second + q.second + p.second) / 3;
                            debugDraw.drawPoint(p.first, p.second, ORANGE);
                            debugDraw.drawPoint(midx, midy, RED);
                        }
                    } else {
                        pair1 = q;
                    }
                    // Three close black blobs is good evidence for a ball
                    if (correlations[count] > 2) {
                        if (debugBall) {
                            debugDraw.drawPoint(p.first, p.second, GREEN);
                        }
                        for (auto i =blobber.blobs.begin();
                             i!=blobber.blobs.end(); i++) {
                            int cX = static_cast<int>((*i).centerX());
                            int cY = static_cast<int>((*i).centerY());
                            if (cX == p.first && cY == p.second) {
                                makeBall((*i), cameraHeight, 0.9, foundBall);
#ifdef OFFLINE
                                foundBall = true;
#else
                                return true;
#endif
                            }
                        }
                    }
                }
            }
            count++;
        }
        // TO DO: This currently finds the first good blob, it ought to find the best
        for (int c = 0; c < count; c++) {
            if (correlations[c] > 1) {
                // good candidate ball
                std::pair<int,int> p = blackBlobs[c];
                for (auto i =blobber.blobs.begin(); i!=blobber.blobs.end(); i++) {
                    int cX = static_cast<int>((*i).centerX());
                    int cY = static_cast<int>((*i).centerY());
                    if (cX == p.first && cY == p.second) {
                        makeBall((*i), cameraHeight, 0.9, foundBall);
#ifdef OFFLINE
                        foundBall = true;
#else
                        return true;
#endif
                    }
                }
            }
        }
        return foundBall;
    }

    /* This function is called when one of our detectors has found a
       ball. For now it creates a ball from the blob used to find it.
       Also, it might set this as the "best" ball based on confidence
       ratings. Since we process balls in terms of highest confidence
       methods first, in practice (on the robot) this won't matter as
       we will stop looking as soon as we find one. But for debugging it
       is helpful to find all of the possible balls that vision could
       detect in every image.
    */
    void BallDetector::makeBall(Blob blob, double cameraHeight, double conf,
                                bool foundBall)
    {
        double bIX = (blob.centerX() - width/2);
        double bIY = (height / 2 - blob.centerY()) -
            blob.firstPrincipalLength();
        double x_rel, y_rel;
        bool belowHoriz = homography->fieldCoords(bIX, bIY, x_rel, y_rel);
        Ball b(blob, x_rel, -1 * y_rel, cameraHeight, height,
               width, topCamera, false, false, false);
        b._confidence = 0.9;
        if (!foundBall) {
            _best = b;
        }
#ifdef OFFLINE
        candidates.push_back(b);
#endif
    }

    /* Main ball finding routine. Uses white and black blobbing to find the
       ball.
     */
    bool BallDetector::findBall(ImageLiteU8 white, double cameraHeight)
	{
		Ball reset;
		_best = reset;
		width = white.width();
		height = white.height();

#ifdef OFFLINE
        candidates.clear();
#endif

        bool foundBall = false;
        int FARAWAYWHITESIZE = 15;
        int BOTTOMEDGEWHITEMAX = 20;
        int BUFFER = 10;

        // First we're going to run the blobber on the black image
        blobber.run(orangeImage.pixelAddr(), orangeImage.width(),
                    orangeImage.height(), orangeImage.pitch());

        // Then we are going to filter out all of the blobs that obviously
        // aren't part of the ball
        std::vector<std::pair<int,int>> blackBlobs;
        for (auto i =blobber.blobs.begin(); i!=blobber.blobs.end(); i++) {
            filterBlackBlobs((*i), blackBlobs);
        }

        // Now run the blobber on the white image
        int MAXWHITEBLOB = 40;
        float MINWHITEAREA = 10.0f;
        blobber2.run(white.pixelAddr(), white.width(), white.height(), white.pitch());
        std::vector<std::pair<int,int>> whiteBlobs;
        // loop through the white blobs hoping to find a ball sized blob
        for (auto i =blobber2.blobs.begin(); i!=blobber2.blobs.end(); i++) {
            int count = filterWhiteBlobs((*i), whiteBlobs, blackBlobs);
            int centerY = static_cast<int>((*i).centerY());
            int principalLength = static_cast<int>((*i).firstPrincipalLength());
            if (count > 2) {
                makeBall((*i), cameraHeight, 0.9, foundBall);
                foundBall = true;
            } else if (count > 0 && topCamera &&
                       centerY + principalLength > height - BUFFER &&
                       principalLength < BOTTOMEDGEWHITEMAX) {
                makeBall((*i), cameraHeight, 0.5, foundBall);
                foundBall = true;
            }
#ifdef OFFLINE
#else
            if (foundBall) {
                return true;
            }
#endif
        }

        if (findCorrelatedBlackBlobs(blackBlobs, cameraHeight, foundBall)) {
#ifdef OFFLINE
            foundBall = true;
#else
            return true;
#endif
        }

        for (auto i =blobber2.blobs.begin(); i!=blobber2.blobs.end(); i++) {
            if (lookForFarAwayBalls((*i))) {
                makeBall((*i), cameraHeight, 0.5, foundBall);
#ifdef OFFLINE
                foundBall = true;
#else
                return true;
#endif
            }
        }

		return foundBall;
	}

	void BallDetector::getColor(int x, int y) {
		currentX = x;
		currentY = y;
	}

	bool BallDetector::isGreen() {
		if (*(greenImage.pixelAddr(currentX, currentY)) > 158) {
			return true;
		}
		return false;
	}

	bool BallDetector::isWhite() {
		if (*(whiteImage.pixelAddr(currentX, currentY)) > 88)// &&
			//*(yImage.pixelAddr(currentX, currentY)) < 350) {
			{
			return true;
		}
		return false;
	}

	bool BallDetector::isOrange() {
		if (*(orangeImage.pixelAddr(currentX, currentY)) > 68) {
			return true;
		}
		return false;
	}

	void BallDetector::setImages(ImageLiteU8 white, ImageLiteU8 green, ImageLiteU8 orange,
		ImageLiteU16 yImg) {
		whiteImage = white;
		greenImage = green;
		orangeImage = orange;
		yImage = yImg;
	}


    Ball::Ball(Blob& b, double x_, double y_, double cameraH_, int imgHeight_,
			   int imgWidth_, bool top, bool os, bool ot, bool ob) :
        blob(b),
		radThresh(.3, .7),
		thresh(.5, .8),
		x_rel(x_),
		y_rel(y_),
		cameraH(cameraH_),
		imgHeight(imgHeight_),
		imgWidth(imgWidth_),
		topCamera(top),
		occludedSide(os),
		occludedTop(ot),
		occludedBottom(ob),
		_confidence(0)
	{
		if (!top) {
			//radThresh = thresh;
			FuzzyThr relaxed(.3, .6);
			thresh = relaxed;
		}
		compute();
	}

	Ball::Ball() :
        blob(0),
		thresh(0, 0),
		radThresh(0, 0),
		_confidence(0),
		dist(200000)
	{ }

	void Ball::compute()
	{
		dist = hypot(x_rel, y_rel);
		double density = blob.area() / blob.count();
		double aspectRatio = (blob.secondPrincipalLength() /
                              blob.firstPrincipalLength());

		double hypotDist = hypot(dist, cameraH);

		expectedDiam = pixDiameterFromDist(hypotDist);

		diameterRatio;
		if (expectedDiam > 2 * firstPrincipalLength) {
			diameterRatio = 2 * firstPrincipalLength / expectedDiam;
		} else {
			diameterRatio = expectedDiam / (2 * firstPrincipalLength);
		}

		//_confidence = (density > thresh).f() * (aspectRatio > thresh).f() * (diameterRatio > radThresh).f();

		if ((occludedSide || occludedTop || occludedBottom) && density > 0.9) {
			_confidence = ((density > thresh) & (aspectRatio > thresh) &
						   (diameterRatio > radThresh)).f();
			_confidence = ((density > thresh) &
						   (diameterRatio > radThresh)).f() * 0.85;
		} else {
			_confidence = ((density > thresh) & (aspectRatio > thresh) &
						   (diameterRatio > radThresh)).f();
		}


		// Hack/Sanity check to ensure we don't see crazy balls
		if (dist > 600) {
			_confidence = 0;
		}
	}

	std::string Ball::properties()
	{
		std::string d("====Ball properties:====\n");
		d += "\tRelativePosition: " + to_string(x_rel) + " "+ to_string( y_rel) + "\n";
		d += "\tHomographyDistance is: " + to_string(dist) + "\n";
		//d += "\tdensity is: " + to_string(blob.area() / blob.count()) + "\n";
		//d += "\tcount is: " + to_string(blob.count()) + "\n";
		d += "\tlocated: (" + to_string(centerX) +  ", " +
			to_string(centerY) + ")\n";
		d += "\tprinceLens: " + to_string(firstPrincipalLength) + " " +
			to_string(firstPrincipalLength) + "\n";
		//d += "\taspectR is: " + to_string(blob.secondPrincipalLength() /
		//								  blob.firstPrincipalLength()) + "\n";
		d += "\texpect ball to be this diam: " + to_string(expectedDiam) + "\n";
		d += "\tdiamRatio: " + to_string(diameterRatio) + "\n";
		d += "\tdiam Confidence: " + to_string((diameterRatio> radThresh).f()) + "\n";
		d += "\n\tconfidence is: " + to_string(_confidence) + "\n====================\n";
		return d;
	}

    // The expected diameter of ball in image at distance d in CM
	double Ball::pixDiameterFromDist(double d) const
	{
		double trig = atan(BALL_RADIUS / d);
		return 2 * imgHeight * trig / VERT_FOV_RAD;
	}



}
}
