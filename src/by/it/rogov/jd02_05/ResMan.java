package by.it.rogov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

class ResMan {

    private static ResMan instance;

    private String path;
    private Locale locale;
    private ResourceBundle rb;

    private ResMan() {
        path = "by.it.rogov.jd02_05.lang.language";
        Locale.setDefault(Locale.US);
        locale = Locale.getDefault();
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

}
