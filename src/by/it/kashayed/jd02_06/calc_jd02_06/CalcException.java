package by.it.kashayed.jd02_06.calc_jd02_06;

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
