package by.it.shekh.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        Scanner sc = new Scanner(System.in);
        String lang = sc.nextLine();
        String country = "";
        switch (lang) {
            case "be":
                country = "BY";
                break;
            case "en":
                country = "US";
                break;
            case "ru":
                country = "RU";
                break;
            default:
                lang = "";
                country = "";
                break;
        }
        rm.setLocale(new Locale(lang, country));
//        if (args.length == 2) {
//            rm.setLocale(new Locale(args[0], args[1]));
//        }
        //Welcome part
        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );
        //Date part
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, new Locale(lang, country));
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
