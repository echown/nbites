
// This file is part of TOOL.
//

package nbtool.gui.logviews.calibrate.console;

import java.awt.FileDialog;
import java.io.File;
import javax.swing.JFileChooser;

import nbtool.gui.logviews.calibrate.TOOL;
import nbtool.gui.logviews.calibrate.CalibrateView;

public class Console {

    public static final int OPEN = FileDialog.LOAD;
    public static final int SAVE = FileDialog.SAVE;
    public static final int FILE = JFileChooser.FILES_ONLY;
    public static final int DIRS = JFileChooser.DIRECTORIES_ONLY;
    public static final int BOTH = JFileChooser.FILES_AND_DIRECTORIES;

    private TOOL tool;

    public Console(TOOL t) {
        tool = t;
    }

    public void print(Object o) {
        System.out.print(o);
    }

    public void println(Object o) {
        System.out.println(o);
    }

    public void println() {
        System.out.println();
    }

    public void message(String msg) {
        System.out.println(msg);
    }

    public void error(String msg) {
        System.err.println(msg);
    }

    public void error(Throwable e) {
        e.printStackTrace();
    }

    public void error(Throwable e, String msg) {
        e.printStackTrace();
        System.err.println(msg);
    }

    public String formatPath(String path) {
        return new File(path).getPath();
    }

    public boolean pathExists(String path) {
        return new File(path).exists();
    }

    public String promptOpen(String title, String curdir) {
        return openDialog(title, curdir, OPEN, BOTH);
    }

    public String promptSave(String title, String curdir) {
        return openDialog(title, curdir, SAVE, BOTH);
    }

    public String promptFileOpen(String title, String curdir) {
        return openDialog(title, curdir, OPEN, FILE);
    }

    public String promptFileSave(String title, String curdir) {
        return openDialog(title, curdir, SAVE, FILE);
    }

    public String promptDirOpen(String title, String curdir) {
        return openDialog(title, curdir, OPEN, DIRS);
    }

    public String promptDirSave(String title, String curdir) {
        return openDialog(title, curdir, SAVE, DIRS);
    }

    public String openDialog(String title, String curdir, int file_mode,
            int filter_mode) {
		return "";
        /*if (System.getProperty("os.name").contains("Mac")) {
            FileDialog fd = new FileDialog(tool.getFrame(), title);
            if (curdir != null)
                fd.setDirectory(curdir);
            fd.setMode(file_mode);

			if (filter_mode == DIRS) {
				System.setProperty("apple.awt.fileDialogForDirectories", "true");
			}

            fd.setVisible(true);

			if (filter_mode == DIRS) {
				System.setProperty("apple.awt.fileDialogForDirectories", "false");
			}

            String fullpath = fd.getDirectory() + fd.getFile();
            fd.dispose();

            if (fd.getFile() == null)
                return null;
            return new File(fd.getDirectory(), fd.getFile()).getPath();

        } else {
            JFileChooser chooser = new JFileChooser();
            if (curdir != null)
                chooser.setCurrentDirectory(new File(curdir));

            chooser.setDialogTitle(title);

            chooser.setFileSelectionMode(filter_mode);
            int retval;
            if (file_mode == OPEN)
                retval = chooser.showOpenDialog(tool.getFrame());
            else
                retval = chooser.showSaveDialog(tool.getFrame());

            if (retval == JFileChooser.APPROVE_OPTION)
                return chooser.getSelectedFile().getPath();
            return null;
			} */
    }

}
