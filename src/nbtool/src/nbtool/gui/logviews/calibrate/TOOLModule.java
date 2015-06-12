package nbtool.gui.logviews.calibrate;

// Necessary for listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// The area in which we draw things
import java.awt.Component;

import java.util.HashMap;
import java.util.Map;

/*import nbtool.gui.logviews.calibrate.Data.DataListener;
import nbtool.gui.logviews.calibrate.Data.Frame;
import nbtool.gui.logviews.calibrate.Data.DataSet;
import nbtool.gui.logviews.calibrate.Data.DataSource;
import nbtool.gui.logviews.calibrate.Data.SourceListener; */

/**
 * Any module for the tool should subclass this one
 * @author Nicholas Dunn
 * @author Jeremy R. Fishman
 */
public abstract class TOOLModule implements ActionListener,
                                            ChangeListener,
                                            KeyListener,
                                            MouseListener,
                                            MouseMotionListener
{
    private static Map<Class<? extends TOOLModule>, TOOLModule> modules =
        new HashMap<Class<? extends TOOLModule>, TOOLModule>();

    protected TOOL t;
    protected boolean changed;

    //protected DataSource currentSource;
    //protected DataSet currentSet;
    //protected Frame currentFrame;

    protected TOOLModule(TOOL tool) {
        t = tool;

        modules.put(getClass(), this);
    }

    public boolean isChanged() {
        return changed;
    }
    public abstract String getDisplayName();
    public abstract Component getDisplayComponent();

    public static void message(Class<? extends TOOLModule> c,
            String message) {
        TOOLModule thisModule = modules.get(c);
        TOOL.CONSOLE.message(thisModule.getDisplayName() + ":: " + message);
    }


    public static void raiseError(String message, TOOLException e)
        throws TOOLException {
        throw new TOOLException(e.getModule(), message, e);
    }

    public static <T extends TOOLModule> void
            raiseError(Class<T> c, String message) throws TOOLException {
        TOOLModule thisModule = modules.get(c);
        throw new TOOLException(thisModule, message);
    }

    public static <T extends TOOLModule> void
            raiseError(Class<T> c, Throwable cause) throws TOOLException {
        TOOLModule thisModule = modules.get(c);
        throw new TOOLException(thisModule, cause);
    }

    public static <T extends TOOLModule> void
            raiseError(Class<T> c, String message, Throwable cause)
            throws TOOLException {
        TOOLModule thisModule = modules.get(c);
        throw new TOOLException(thisModule, message, cause);
    }

    public static void logError(String message, TOOLException e) {
        TOOL.CONSOLE.error(new TOOLException(e.getModule(), message, e));
    }

    public static void logError(TOOLException e) {
        TOOL.CONSOLE.error(e);
    }

    public static <T extends TOOLModule> void
            logError(Class<T> c, String message) {
        TOOLModule thisModule = modules.get(c);
        TOOL.CONSOLE.error(new TOOLException(thisModule, message));
    }

    public static <T extends TOOLModule> void
            logError(Class<T> c, Throwable cause) {
        TOOLModule thisModule = modules.get(c);
        TOOL.CONSOLE.error(new TOOLException(thisModule, cause));
    }

    public static <T extends TOOLModule> void
            logError(Class<T> c, String message, Throwable cause) {
        TOOLModule thisModule = modules.get(c);
        TOOL.CONSOLE.error(new TOOLException(thisModule, message, cause));
    }


    // Fulfill listener contracts

    // ActionListener contract
    public void actionPerformed(ActionEvent e){}

    // KeyListener contract
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // Mouse/MouseMotion contract
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

    // Called whenever the tab containing the module is selected
    public void stateChanged(ChangeEvent e) {}

}
