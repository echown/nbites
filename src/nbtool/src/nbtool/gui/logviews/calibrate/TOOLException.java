package nbtool.gui.logviews.calibrate;

public class TOOLException extends Exception {

    private TOOLModule module;

    public TOOLException(TOOLModule m) {
        super();
        module = m;
    }

    public TOOLException(TOOLModule m, String message) {
        super(message);
        module = m;
    }

    public TOOLException(TOOLModule m, Throwable cause) {
        super(cause);
        module = m;
    }

    public TOOLException(TOOLModule m, String message, Throwable cause) {
        super(message, cause);
        module = m;
    }

    public TOOLModule getModule() {
        return module;
    }

    public String toString() {
        String s = module.getDisplayName() + "::TOOLException";
        if (getMessage() == null)
            s += ": " + getMessage();
        return s;
    }

}
