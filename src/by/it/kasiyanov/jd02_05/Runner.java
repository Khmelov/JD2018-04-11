package by.it.kasiyanov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        Locale locale = new Locale("en", "US");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter \"ru / be / en\" for changing language or \"end\" to stop");
        String line = scanner.nextLine();

        switch (line){
            case ("ru"):
                locale = new Locale("ru", "RU");
                break;
            case ("be"):
                locale = new Locale("be", "BY");
                break;
            case ("en"):
                locale = new Locale("en", "US");
                break;
            case ("end"):
                break;
        }
        rm.setLocale(locale);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,locale);
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        System.out.println(rm.getString(Massage.WELCOME));
        System.out.println(rm.getString(Massage.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
                );
    }
}
