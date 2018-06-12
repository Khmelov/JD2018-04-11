package by.it.rogov.calc;

public class CalcException extends Exception {
    Logger loger=Logger.getInstans();

    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: " + message);
        loger.toLog("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
        loger.toLog("ERROR: " + message + "," + cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
        loger.toLog(cause.toString());
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
        loger.toLog("ERROR: " + message + ", " + cause + ", " + enableSuppression + ", " + writableStackTrace);
    }
}
