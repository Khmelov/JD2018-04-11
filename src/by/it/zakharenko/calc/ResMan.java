package by.it.zakharenko.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

class ResMan {

    private static ResMan instance;

    private String path;
    private Locale locale;
    private DateFormat date;
    private ResourceBundle rb;

    private ResMan() {
        path = "by.it.zakharenko.calc.lang.language";
        locale = Locale.getDefault();
        date = DateFormat.getDateInstance();
        rb = ResourceBundle.getBundle(path, locale);
    }

    static ResMan getInstance() {
        if (instance == null) {
            instance = new ResMan();
        }
        return instance;
    }

    String getString(String name) {
        return rb.getString(name);
    }

    void setLocale(Locale locale) {
        this.locale = locale;
        rb = ResourceBundle.getBundle(path, this.locale);
    }

    void setDate(Locale locale) {
        this.date = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);

    }

    String getDate() {
        return date.format(new Date());
    }
}
