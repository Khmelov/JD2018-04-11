package by.it.kurmaz.calc;

interface LogBuilder {

    String getMessage(CalcException exception);

    String getMessage(String message);

    String createStartMessage();

    String createEndMessage();

}