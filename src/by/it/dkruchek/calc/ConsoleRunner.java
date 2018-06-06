package by.it.dkruchek.calc;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
public class ConsoleRunner {

    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        rm.setLocale(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        System.out.println(rm.getString("msg.change") + " " + rm.getLocale());
        String line;
        while (!(line = sc.nextLine()).equals("end")){
            switch (line){
                case "be":
                    rm.setLocale(new Locale("be", "BY"));
                    System.out.println(rm.getString("msg.change") + " " + rm.getLocale());
                    break;
                case "ru":
                    rm.setLocale(new Locale("ru", "RU"));
                    System.out.println(rm.getString("msg.change") + " " + rm.getLocale());
                    break;
                case "en":
                    rm.setLocale(new Locale("en", "US"));
                    System.out.println(rm.getString("msg.change") + " " + rm.getLocale());
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        printer.print(result);
                    }
                    catch (CalcException e){
                        System.out.println(e.getMessage());
                    }
            }
        }
    }
}
