package by.it.zakharenko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        if (args.length == 2) {
            rm.setLocale(new Locale(args[0], args[1]));
        }
        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            if (command.equals("ru")) {
                rm.setLocale(new Locale("ru", "RU"));
                rm.setDate(new Locale("ru"));
            } else if (command.equals("be")) {
                rm.setLocale(new Locale("be", "BY"));
                rm.setDate(new Locale("be"));
            } else if (command.equals("en")) {
                rm.setLocale(new Locale("en", "US"));
                rm.setDate(new Locale("en"));
            } else {
                rm.setLocale(Locale.getDefault());
                rm.setDate(Locale.getDefault());
            }
            System.out.println(rm.getDate());
            System.out.println(rm.getString(Message.WELCOME));
            System.out.println(rm.getString(Message.QUESTION));
            System.out.printf("%s: %s",
                    rm.getString(Res.AUTHOR),
                    rm.getString(Res.NAME)
            );
            System.out.println();
        }
    }
}
