package by.it.dkruchek.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 6/4/2018.
 */
public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        String country = "";
        String language = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println(rm.getString(Message.START));
        String lang = scanner.next();
        switch (lang){
            case "be":
                country = "BY";
                language = "be";
                break;
            case "ru":
                country = "RU";
                language = "ru";
                break;
            case "en":
                country = "US";
                language = "en";
                break;
        }
        Locale locale = new Locale(language, country);
        // set new locale
        rm.setLocale(locale);
        // set date format
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        Date date = new Date();
        System.out.println(df.format(date));

        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME));
    }
}
