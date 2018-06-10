package by.it.shumilov.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        String line;
        DateFormat df ;

        ResMan rm = ResMan.getInstance();
        if(args.length == 2) {
            rm.setLocale(new Locale(args[0], args[1]));

            System.out.println(rm.getString(Message.WELCOM));
            System.out.println(rm.getString(Message.QUESTION));
            System.out.printf("%s: %s\n", rm.getString(Res.AUTHOR), rm.getString(Res.NAME));
            df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(args[0], args[1]));
            System.out.println(df.format(new Date()));
        }

        Scanner scanner=new Scanner(System.in);

        while (!(line=scanner.nextLine()).equals("end")){
            String country = "";
            switch (line){
                case "ru": country = "RU";break;
                case "be": country = "BY";break;
                default: country = "US"; line = "en";
            }


            Locale locale = new Locale(line,country);
            df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);

            rm.setLocale(locale);
            System.out.println(rm.getString(Message.WELCOM));
            System.out.println(rm.getString(Message.QUESTION));
            System.out.printf("%s: %s\n", rm.getString(Res.AUTHOR), rm.getString(Res.NAME));
            System.out.println(df.format(new Date()));

        }



    }
}
