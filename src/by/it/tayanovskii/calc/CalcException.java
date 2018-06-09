package by.it.tayanovskii.calc;

public class CalcException extends Exception {

    public CalcException() {
    }

    public CalcException(String message) {
        super(ResMan.getString(Message.error) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResMan.getString(Message.error) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(Message.error + message, cause, enableSuppression, writableStackTrace);
    }
}
