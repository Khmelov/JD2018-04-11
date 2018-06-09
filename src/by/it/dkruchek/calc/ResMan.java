package by.it.dkruchek.calc;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Dmitriy.Kruchek on 6/4/2018.
 */
public class ResMan {

    private static ResMan instance;

    private String path = "by.it.dkruchek.calc.lang.language";

    public Locale getLocale() {
        return locale;
    }

    private Locale locale = Locale.getDefault();
    private ResourceBundle rb = ResourceBundle.getBundle(path, locale);

    private ResMan(){
    }

    static ResMan getInstance(){
        if (instance==null){
            instance = new ResMan();
        }
        return instance;
    }

    String getString(String name){
        return rb.getString(name);
    }

    void setLocale(Locale locale){
        this.locale = locale;
        rb = ResourceBundle.getBundle(path, locale);
        //System.out.println(getString("msg.change") + " " + locale.getDisplayLanguage());
    }

}