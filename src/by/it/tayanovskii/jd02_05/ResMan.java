package by.it.tayanovskii.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

class ResMan {

    private static ResMan instance;

    private String path;
    private Locale locale;
    private DateFormat dateFormat;
    private ResourceBundle rb;

    private ResMan() {
        path = "by.it.tayanovskii.jd02_05.lang.language";
        locale = Locale.getDefault();
        dateFormat = DateFormat.getDateInstance();
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
    void setDateFormat (Locale locale)
    {
        this.dateFormat=DateFormat.getDateInstance(DateFormat.MEDIUM, locale);

    }

    String getDate ()
    {
        return dateFormat.format(new Date());
    }

}
