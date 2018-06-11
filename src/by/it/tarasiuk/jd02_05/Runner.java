package by.it.tarasiuk.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        Locale locale = Locale.getDefault();
        Scanner scanner = new Scanner(System.in);
        System.out.println(rm.getString(Message.REQUEST));
        String input;

        while (!(input = scanner.next()).equals("end")) {
            switch (input) {
                case "en":
                    locale = new Locale("en", "US");
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    break;
            }
            rm.setLocale(locale);
            System.out.println(rm.getString(Message.WELCOME));
            System.out.println(rm.getString(Message.QUESTION));
            System.out.printf("%s: %s", rm.getString(Res.AUTHOR), rm.getString(Res.NAME));
            System.out.println("\n" + DateFormat.getDateInstance(DateFormat.FULL, locale).format(new Date()));
            System.out.println(rm.getString(Message.REQUEST));
        }
    }
}
