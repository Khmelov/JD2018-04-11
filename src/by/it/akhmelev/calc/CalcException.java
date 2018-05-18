package by.it.akhmelev.calc;

public class CalcException extends Exception{

    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: "+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

//    @Override
//    public String toString() {
//        return this.getMessage();
//    }
}
