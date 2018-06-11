package by.it.kurmaz.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


class bigLogBuilder implements LogBuilder {

    private DateFormat dateFormat;


    bigLogBuilder(Locale locale) {
        dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
    }

    @Override
    public String getMessage(CalcException exception) {
        String cause;
        if (exception.getCause() != null)
            cause = exception.getCause().toString();
        else
            cause = "Cause is on your side";
        return (dateFormat.format(new Date()) + " " + exception.getMessage() + " " + cause);
    }

    @Override
    public String getMessage(String message) {
        return (dateFormat.format(new Date()) + " " + message);
    }

    public String createStartMessage() {
        return (dateFormat.format(new Date()) + " " + ConsoleRunner.resMan.getString("msg.welcome") +" "
                + ConsoleRunner.resMan.getString("res.author") + ": " + ConsoleRunner.resMan.getString("res.name"));
    }

    public String createEndMessage() {
        return (dateFormat.format(new Date()) + " " + ConsoleRunner.resMan.getString("msg.finish"));
    }
}
