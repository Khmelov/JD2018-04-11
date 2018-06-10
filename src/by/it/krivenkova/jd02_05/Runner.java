package by.it.krivenkova.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        System.out.println("Input language [ru, be, en]:");
        Scanner sc = new Scanner(System.in);

//A
        /*if (args.length < 2){
         rm.setLocale(Locale.US);
        }
        else {
            rm.setLocale(new Locale(args[0], args[1]));
        }*/



        Date date = new Date();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (s) {
            case "ru":
                rm.setLocale(new Locale("ru", "RU"));
                break;
            case "be":
                rm.setLocale(new Locale("be", "BY"));
                break;
            case "en":
                rm.setLocale(new Locale("en", "US"));
                break;
                default:
                    rm.setLocale(new Locale("en", "US"));
                    break;
        }
        DateFormat dt = DateFormat.getDateInstance(DateFormat.FULL, Locale.forLanguageTag(s));



        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );
        System.out.println();
        System.out.println(dt.format(date));
//B



    }
}
