package by.it.tayanovskii.calc;

import java.util.Locale;
import java.util.ResourceBundle;

class ResMan {

    private static ResMan instance;

    private String path;
    private Locale locale;
    private static ResourceBundle rb;

    private ResMan() {
        path = "by.it.tayanovskii.calc.lang.language";
        locale = Locale.getDefault();
        rb = ResourceBundle.getBundle(path, locale);
    }

    static ResMan getInstance() {
        if (instance == null) {
            instance = new ResMan();
        }
        return instance;
    }

    static String getString(String name) {
        return rb.getString(name);
    }

    void setLocale(Locale locale) {
        this.locale = locale;
        rb = ResourceBundle.getBundle(path, this.locale);
    }

}
