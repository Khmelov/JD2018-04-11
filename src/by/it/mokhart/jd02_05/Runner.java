package by.it.mokhart.jd02_05;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        by.it.mokhart.jd02_05.ResMan rm= by.it.mokhart.jd02_05.ResMan.getInstance();
        if (args.length==2){
            rm.setLocale(new Locale(args[0],args[1]));
        }
        System.out.println(rm.getString(Message.WELCOME));
        System.out.println(rm.getString(Message.QUESTION));
        System.out.printf("%s: %s",
                rm.getString(by.it.mokhart.jd02_05.Res.AUTHOR),
                rm.getString(Res.NAME)
        );
    }
}
