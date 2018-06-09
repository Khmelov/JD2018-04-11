package by.it.shumilov.Calc;

public class CalcException extends Exception {

    private static GetStr getStr = GetStr.getInstance();
    private Logger logger = Logger.getLogger();

    public CalcException() {

    }

    public CalcException(String message) {

        super(String.format("%s %s",getStr.getString(Err.ERROR), message));
        logger.logError(String.format("%s %s",getStr.getString(Err.ERROR), message));

    }

    public CalcException(String message, Throwable cause) {
        super(String.format("%s %s", getStr.getString(Err.ERROR), message), cause);
        logger.logError(String.format("%s %s",getStr.getString(Err.ERROR), message));
    }

    public CalcException(Throwable cause) {

        super(cause);
    }

    /*@Override
    public String toString() {

        return this.getMessage();
    }*/
}
