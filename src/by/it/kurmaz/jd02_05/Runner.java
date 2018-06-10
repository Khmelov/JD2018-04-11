package by.it.kurmaz.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        ResMan res = ResMan.getInstance();
        /*if (args.length == 2) {
            res.setLocale(new Locale(args[0], args[1]));
        } */
        Scanner scanner = new Scanner(System.in);
        String readLine;
        Locale locale = Locale.getDefault();
        DateFormat dateFormat;
        System.out.println("Type \"RU\", \"BY\" or \"EN\" to switch language, or \"end\" to finish");
        while (!(readLine = scanner.nextLine()).equals("end")) {
            switch (readLine){
                case "RU":
                    locale = new Locale("ru", "RU");
                    break;
                case "EN":
                    locale = new Locale("en", "US");
                    break;
                case "BY":
                    locale = new Locale("be", "BY");
                    break;
            }
            res.setLocale(locale);
            dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
            System.out.println(res.getString("msg.welcome"));
            System.out.println(res.getString("msg.question"));
            System.out.println(res.getString("res.author") +": " + res.getString("res.name"));
            System.out.println("Current date is: " + dateFormat.format(new Date()));
        }
    }
}
