package by.it.zakharenko.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    static ResMan rm = ResMan.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).equals("end")) {
            switch (line) {
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
                    try {
                        Var var = parser.calc(line.trim());
                        String str = parser.getLetters(line);
                        if ((str != null)) {
                            printer.print(var, str);
                        } else
                            printer.print(var);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }
}