package by.it.dkruchek.calc;

/**
 * Created by Dmitriy.Kruchek on 5/20/2018.
 */
public class CalcException extends Exception{
    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+ message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+ message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: "+ message, cause, enableSuppression, writableStackTrace);
    }
}
