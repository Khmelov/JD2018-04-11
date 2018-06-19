package by.it.tayanovskii.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        ResMan rm = ResMan.getInstance();
        Scanner scanner=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        Printer printer=new Printer();
        Logger logger = Logger.getLogger();
        ReportBuilder shortReportBuilder=new ShortReportBuilder();
        ReportBuilder longReportBuilder=new LongReportBuilder();
        System.out.println("Set report long(l) or short(s)");
        if(scanner.hasNext("s") || scanner.hasNext("short")) {
            logger.setReportBuilder(shortReportBuilder);
        }
        else
        {
            logger.setReportBuilder(longReportBuilder);
        }
        System.out.println("Calculate: ");
        scanner=new Scanner(System.in);
        logger.reportBuilder.addHead();
        logger.reportBuilder.addStartTime();
        while (!(line = scanner.nextLine()).equals("end")){
            logger.addMessage(line);
            switch (line){
                case "printvar":
                {
                    logger.addMessage(Var.printvar());
                    break;

                }
                case  "sortvar":
                {
                    Var.sortvar();
                    break;

                }
                case  "ru":
                {
                    rm.setLocale(new Locale("ru", "RU"));
                    break;

                }
                case  "be":
                {
                    rm.setLocale(new Locale("be", "BY"));
                    break;

                }
                case  "en":
                {
                    rm.setLocale(new Locale("en", "US"));
                    break;

                }
                default: {
                    try {

//                        Var var = parser.calc(line);
//                        printer.print(var);
                        Var result = parser.calcExpression(line);
                        printer.print(result);
                        logger.addMessage(result.toString());
                    } catch (CalcException e) {
                        logger.addMessage(e);
                        System.out.println(e.getMessage());
                    }

                }
            }

        }
        logger.reportBuilder.addEndTime();
        logger.writeLogToFile();
    }
}
