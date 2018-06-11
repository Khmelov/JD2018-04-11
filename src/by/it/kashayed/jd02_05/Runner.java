package by.it.kashayed.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ResMan manager = ResMan.INSTANCE;
        Date date = new Date();
        Scanner scanner = new Scanner(System.in);
        DateFormat df =DateFormat.getDateInstance(DateFormat.FULL,new Locale("ru","RU"));
        String s ;
        while(!(s=scanner.next()).equals("end")) {
            if (s.equals("ru")) {
                System.out.printf("%s\n%s\n%s\n%s: %s\n", df.format(date), manager.getString("msg1"),
                        manager.getString("msg2"),
                        manager.getString("msg3"),
                        manager.getString("msg4"));
            } else if (s.equals("be")) {
                manager.changeResource(new Locale("be", "BY"));
                df = DateFormat.getDateInstance(DateFormat.FULL, new Locale("be", "BY"));
                System.out.printf("%s\n%s\n%s\n%s: %s\n", df.format(date), manager.getString("msg1"),
                        manager.getString("msg2"),
                        manager.getString("msg3"),
                        manager.getString("msg4"));
            } else if (s.equals("en")) {
                manager.changeResource(new Locale("en", "US"));
                df = DateFormat.getDateInstance(DateFormat.FULL, new Locale("en", "US"));

                System.out.printf("%s\n%s\n%s\n%s: %s\n", date, manager.getString("msg1"),
                        manager.getString("msg2"),
                        manager.getString("msg3"),
                        manager.getString("msg4"));
            }
            else System.out.println("Язык не определен");
        }
    }
}
