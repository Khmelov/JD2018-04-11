package by.it.kurmaz.jd02_05;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        ResMan res = ResMan.getInstance();
        if (args.length == 2) {
            res.setLocale(new Locale(args[0], args[1]));
        }
        //res.setLocale(new Locale("be", "BY"));
        System.out.println(res.getString("msg.welcome"));
        System.out.println(res.getString("msg.question"));
        System.out.println(res.getString("res.author"));
        System.out.println(res.getString("res.name"));
    }
}
