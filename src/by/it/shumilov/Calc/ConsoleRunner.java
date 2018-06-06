package by.it.shumilov.Calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        GetStr getStr = GetStr.getInstance();
        Locale locale ;

        while (!(line = sc.nextLine()).equals("end")){

            switch (line){
                case "ru": locale = new Locale(line,"RU");break;
                case "be":locale = new Locale(line,"BY");break;
                case "en": locale = new Locale(line,"US"); break;
                default: locale = Locale.getDefault();
            }
            getStr.setLocale(locale);

            Var var = null;
            try {
                var = parser.calc(line.trim());
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
