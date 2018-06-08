package by.it.dkruchek.calc;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
public class ConsoleRunner {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        ResMan rm = ResMan.getInstance();
        rm.setLocale(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        ReportBuilder reporter = new ReportBuilder(true);
        reporter.buildStartDate();
        System.out.println(rm.getString("msg.change") + " " + rm.getLocale());
        String line;
        while (!(line = sc.nextLine()).equals("end")){
            reporter.buildOperation(line);
            switch (line){
                case "be":
                    rm.setLocale(new Locale("be", "BY"));
                    //logger.log(rm.getString("msg.change") + " " + rm.getLocale(), LogLevel.INFO);
                    break;
                case "ru":
                    rm.setLocale(new Locale("ru", "RU"));
                    //logger.log(rm.getString("msg.change") + " " + rm.getLocale(), LogLevel.INFO);
                    break;
                case "en":
                    rm.setLocale(new Locale("en", "US"));
                    //logger.log(rm.getString("msg.change") + " " + rm.getLocale(), LogLevel.INFO);
                    break;
                default:
                    try {
                        Var result = parser.calc(line);
                        printer.print(result);
                        reporter.buildOperation(result.toString());
                    }
                    catch (CalcException e){
                        reporter.buildException(e);
                        System.out.println(e.getMessage());
                    }
            }
        }
        reporter.buildEndDate();
        reporter.printReport();
    }
}
