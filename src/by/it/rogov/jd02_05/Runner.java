package by.it.rogov.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        System.out.println(Locale.getDefault());
        DateFormat dataFormat;
        if (args.length == 2) {
            rm.setLocale(new Locale(args[0], args[1]));
        }
        Locale locale;
        String contry = "", language = "";
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        switch (line) {
            case ("ru"): {
                language = "ru";
                contry = "RU";
                break;
            }
            case ("be"): {
                language = "be";
                contry = "BY";
                break;
            }
            case ("en"): {
                language = "en";
                contry = "US";
                break;
            }
        }
        locale = new Locale(language, contry);
        rm.setLocale(locale);
        dataFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dataFormat.format(new Date()));
        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );
    }
}
