package by.it.dkruchek.calc;

/**
 * Created by Dmitriy.Kruchek on 5/20/2018.
 */
public class CalcException extends Exception{

    private static ResMan rm = ResMan.getInstance();

    public CalcException() {
    }

    public CalcException(String message) {
        super(rm.getString(ERROR.SIMPLE) + ": " + message);
    }

    public CalcException(String message, Throwable cause) {
        super(rm.getString(ERROR.SIMPLE) + ": " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(rm.getString(ERROR.SIMPLE) + ": " + message, cause, enableSuppression, writableStackTrace);
    }
}
