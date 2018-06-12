package by.it.kashayed.jd02_04.jd02_04new;

public class CalcException extends Exception{
    public CalcException() {
        super("ERROR:");
    }

    public CalcException(String message) {
        super("ERROR:"+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }


}
