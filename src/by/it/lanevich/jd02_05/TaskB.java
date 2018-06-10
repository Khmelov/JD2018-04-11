package by.it.lanevich.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskB {
    public static void main(String[] args) throws IOException {
        String language = "";
        Date date = new Date();

        ResMan rm = ResMan.getInstance();
        if (args.length == 2) {
            rm.setLocale(new Locale(args[0], args[1]));
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!language.equals("end")) {

            System.out.println("\nВведите язык вывода данных (be-белорусский; ru-русский; en-английский) или \"end\" для окончания работы:");
            language = reader.readLine();
            switch (language) {
                case "be":
                    rm.setLocale(new Locale("be", "BY"));
                    break;
                case "ru":
                    rm.setLocale(new Locale("ru", "RU"));
                    break;
                case "en":
                    rm.setLocale(new Locale("en", "US"));
                    break;
                default:
                    return;
            }
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag(language));
            System.out.println(rm.getString(Message.WELCOME));
            System.out.println(rm.getString(Message.QUESTION));
            System.out.printf("%s: %s",
                    rm.getString(Res.AUTHOR),
                    rm.getString(Res.NAME)
            );
            System.out.println();
            System.out.println(df.format(date));
        }
    }
}
