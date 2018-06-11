package by.it.tayanovskii.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        if (args.length == 2) {
            rm.setLocale(new Locale(args[0], args[1]));
        }
        System.out.println(rm.getDate());
        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        String str;
        while (!(str = scanner.nextLine()).equals("end")) {
            if (str.equals("ru")) {
                rm.setLocale(new Locale("ru", "RU"));
                rm.setDateFormat(new Locale("ru"));

            } else if (str.equals("be")) {
                rm.setLocale(new Locale("be", "BY"));
                rm.setDateFormat(new Locale("be"));
            } else if (str.equals("en")) {
                rm.setLocale(new Locale("en", "US"));
                rm.setDateFormat(new Locale("en"));
            } else {
                rm.setLocale(Locale.getDefault());
                rm.setDateFormat(Locale.getDefault());

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
