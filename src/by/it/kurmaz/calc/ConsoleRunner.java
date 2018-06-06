package by.it.kurmaz.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    static ResMan resMan = ResMan.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Printer printer = new Printer();
        Parser parser = new Parser();
        System.out.println("Type \"RU\", \"BY\" or \"EN\" to switch language");
        line = scanner.nextLine();
        switch (line){
            case "RU":
                resMan.setLocale(new Locale("ru", "RU"));
                break;
            case "EN":
                resMan.setLocale(new Locale("en", "US"));
                break;
            case "BY":
                resMan.setLocale(new Locale("be", "BY"));
                break;
        }

        System.out.println(resMan.getString("res.author") + ": " + resMan.getString("res.name"));
        System.out.println(resMan.getString("msg.recover"));
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("yes")) {
                try {
                    Variables.recover();
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    Logger.Log(e.getMessage());
                }
                System.out.println(resMan.getString("msg.proceed"));
                continue;
            }
            else if (line.equals("no")) {
                System.out.println(resMan.getString("msg.proceed"));
                continue;
            }
            if (line.contains(Patterns.PRINTVAR)) {
                Variables.printHash();
                System.out.println(resMan.getString("msg.proceed"));
                continue;
            }
            else if (line.contains(Patterns.SORTVAR)) {
                Variables.printSort();
                System.out.println(resMan.getString("msg.proceed"));
                continue;
            }
            try {
                String result = parser.processLine(line);
                if (result == null)
                    printer.varPrint();
                else
                    printer.resultPrint(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                Logger.Log(e.getMessage());
            }
        }
        Variables.save();
    }
}
