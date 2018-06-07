package by.it.kurmaz.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    static ResMan resMan = ResMan.getInstance();

    public static void main(String[] args) {
        Logger logger = new Logger();
        Scanner scanner = new Scanner(System.in);
        String line;
        Printer printer = Printer.getInstance();
        Parser parser = Parser.getInstance();
        System.out.println("Type \"RU\", \"BY\" or \"EN\" to switch language, or type \"DEF\" to use default");
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
            case "DEF":
                break;
        }
        LogBuilder logBuilder = Math.random() > 0.5? new shortLogBuilder(resMan.getLocale()): new bigLogBuilder(resMan.getLocale());
        logger.setLogBuilder(logBuilder);
        logger.start();
        System.out.println(resMan.getString("msg.recover"));
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("yes")) {
                try {
                    Variables.recover();
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    logger.createLog(e);
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
                else {
                    printer.resultPrint(result);
                    logger.createLog(line + " " + resMan.getString("msg.result") + result);
                }
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                logger.createLog(e);
            }
        }
        try {
            Variables.save();
        } catch (CalcException e) {
            System.out.println(e.getMessage());
            logger.createLog(e);
        }
        logger.finish();
    }
}
