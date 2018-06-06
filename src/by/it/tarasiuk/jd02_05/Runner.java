package by.it.tarasiuk.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println(rm.getString(Message.REQUEST));

        if (scanner.next().equals("en")){
            args[0]="en";
            args[1]="US";
        }
        else if (scanner.next().equals("ru")) {
            args[0]="ru";
            args[1]="RU";
        }
        else if (scanner.next().equals("be")) {
            args[0]="be";
            args[1]="BY";
        }

        if (args.length == 2) {
            rm.setLocale(new Locale(args[0], args[1]));
        }

        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s", rm.getString(Res.AUTHOR), rm.getString(Res.NAME));
        System.out.println("\n"+DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag(args[1])).format(new Date()));
    }
}
