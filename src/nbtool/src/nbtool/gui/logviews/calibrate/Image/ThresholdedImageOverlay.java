package nbtool.gui.logviews.calibrate.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import java.awt.AlphaComposite;
import java.util.Iterator;

//import TOOL.TOOL;
import nbtool.gui.logviews.calibrate.Pair;
import nbtool.gui.logviews.calibrate.vision.Vision;


/**
 * This class is used to draw the shapes of objects recognized + other information on
 * the thresholded image panel (display panel) in the calibration part of the tool
 *
 * Inspired by ImageOverlay, but just a very basic version
 * @author Octavian Neamtu 2009
 */
public class ThresholdedImageOverlay extends BufferedImage{
    private static final Color[] COLORS = Vision.COLORS;

    private int width, height;

    /**
     * Constructs an ThresholdedImageOverlay of width and height as specified by
     * creating a buffered image of type ARGB (alpha channel specified)
     * and initializes the array of pixels to be TRANSPARENT to start.
     * @param width number of pixels wide the image will be
     * @param height number of pixels high
     */
    public ThresholdedImageOverlay(int width, int height){

		super(width, height, BufferedImage.TYPE_INT_ARGB);

		this.width = width;
		this.height = height;
		resetPixels();
    }

    //resets all the pixel to the default transparent pixel
    public void resetPixels(){
		for(int w = 0; w < width; w++){
			for(int h = 0; h < height; h++){
				setRGB(w,h,0x0);
			}
		}
    }
    //draws a rectangle starting from x,y and of width w and height h
    public void drawRectangle(int x, int y, int w, int h,
							  byte thickness, byte color){
		Graphics2D g = createGraphics();

		g.setColor(new Color(COLORS[color].getRGB()));
		for (int k = 1; k <= thickness; k++)
			g.drawRect(x-k, y-k, w+2*k, h+2*k);
    }
    //draws a polygon between 4 points
    public void drawPolygon(int x1, int x2, int x3, int x4,
							int y1, int y2, int y3, int y4,
							byte thickness, byte color){
		Graphics2D g = createGraphics();

		g.setColor(new Color(COLORS[color].getRGB()));
		for (int k = 1; k <= thickness; k++){
			int[] x = {x1-k, x2+k, x3+k, x4-k, x1-k};
			int[] y = {y1-k, y2-k, y3+k, y4+k, y1-k};
			g.drawPolyline(x, y, 5);
		}
    }
    //draws an oval like a rectangle starting from x,y (like MsPaint)
    public void drawOval(int x, int y, int w, int h,
						 byte thickness, byte color) {
		Graphics2D g = createGraphics();

		g.setColor(new Color(COLORS[color].getRGB()));
		for (int k = 1; k <= thickness; k++)
			g.drawOval(x-k, y-k, w+2*k, h+2*k);
    }
    //draws a circle centered in cx, cy of radius r
    public void drawCircle(int cx, int cy, int radius,
						   byte thickness, byte color) {
		Graphics2D g = createGraphics();

		g.setColor(new Color(COLORS[color].getRGB()));
		for (int k = 1; k <= thickness; k++)
			g.drawOval(cx-radius-k, cy-radius-k, (radius+1)*2, (radius+1)*2);
    }
    //draws a line
    public void drawLine(int bx, int by, int ex, int ey,
						 byte thickness, byte color) {
		Graphics2D g = createGraphics();

		g.setColor( new Color(COLORS[color].getRGB()));
		for (int k = 0; k < thickness; k++)
			g.drawLine(bx-k, by-k, ex-k, ey-k);
    }
    //draws a cross
    public void drawCross(int x, int y, byte size,
						  byte thickness, byte color){
		Graphics2D g = createGraphics();

		g.setColor(new Color(COLORS[color].getRGB()));
		for (int k = 0; k < thickness; k++){
			g.drawLine(x-size, y+k, x+size, y+k);
			g.drawLine(x+k, y-size, x+k, y+size);
		}
    }
}
