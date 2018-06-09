package by.it.kurmaz.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

class ResMan {

    private static ResMan instance;
    private String path = "by.it.kurmaz.jd02_05.lang.language";
    private Locale locale = Locale.getDefault();

    private ResourceBundle rb = ResourceBundle.getBundle(path, locale);

    private ResMan() {}

    static ResMan getInstance() {
        if (instance == null)
            instance = new ResMan();
        return instance;
    }

    String getString(String name) {
        return rb.getString(name);
    }

    void setLocale (Locale locale) {
        this.locale = locale;
        rb = ResourceBundle.getBundle(path, locale);
    }
}
