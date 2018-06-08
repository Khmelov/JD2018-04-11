package by.it.gavrilchik.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan rm=ResMan.getInstance();
        rm.setLocale(new Locale("be","BY"));
        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s:%s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );

    }
}
