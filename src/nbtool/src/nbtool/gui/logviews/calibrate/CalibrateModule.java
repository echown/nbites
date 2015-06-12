package nbtool.gui.logviews.calibrate;

import java.awt.Component;


public class CalibrateModule extends TOOLModule {

    private Calibrate calibrate;

    public CalibrateModule(TOOL tool) {
        super(tool);

        calibrate = new Calibrate(t);
        //t.getDataManager().addDataListener(calibrate);

        // add the calibrate panel as a key listener; it handles all the
        // work
        //t.getFrame().addKeyListener(calibrate.getCalibratePanel());
    }

    public String getDisplayName() {
        return "Calibrate";
    }

    public Component getDisplayComponent() {
        return calibrate.getContentPane();
    }

    public Calibrate getCalibrate() { return calibrate; }


}
