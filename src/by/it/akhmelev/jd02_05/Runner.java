package by.it.akhmelev.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan rm=ResMan.getInstance();
        if (args.length==2){
            rm.setLocale(new Locale(args[0],args[1]));
        }
        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(Res.AUTHOR),
                rm.getString(Res.NAME)
        );
    }
}
