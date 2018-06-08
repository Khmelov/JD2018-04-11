package by.it.kashayed.jd02_05.jd02_05Old;

import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        ResMan rn = ResMan.getInstance();
        if(args.length==2){
            rn.setLocale(new Locale(args[0],args[1]));
        }
        System.out.println(rn.getString(MSG.WELCOME));
        System.out.println(rn.getString(MSG.QUESTION));
        System.out.printf("%s: %s",
                rn.getString(Res.AUTHOR),
                rn.getString(Res.NAME)
        );

    }
}
