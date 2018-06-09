package by.it.kurmaz.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class shortLogBuilder implements LogBuilder {

    private DateFormat dateFormat;

    shortLogBuilder(Locale locale) {
        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    }

    @Override
    public String getMessage(CalcException exception) {
        String messages[] = exception.getMessage().split(":");
        return (dateFormat.format(new Date()) + " " + messages[0]);
    }

    @Override
    public String getMessage(String message) {
        return (dateFormat.format(new Date()) + " " + message);
    }

    public String createStartMessage() {
        return (dateFormat.format(new Date()) + " " + ConsoleRunner.resMan.getString("msg.welcome") + " "
                    + ConsoleRunner.resMan.getString("res.author") + ": " + ConsoleRunner.resMan.getString("res.name"));
    }

    public String createEndMessage() {
        return (dateFormat.format(new Date()) + " " + ConsoleRunner.resMan.getString("msg.finish"));
    }
}
