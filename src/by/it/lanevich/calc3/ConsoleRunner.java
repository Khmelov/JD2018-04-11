package by.it.lanevich.calc3;


import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    static ResMan rm= ResMan.getInstance();
    static Logger logger=Logger.getLogger();
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        String line;

        Parser parser=new Parser();
        Printer printer=new Printer();

        while(!(line=scan.nextLine()).equals("end")){

            switch (line) {
                case "printvar":
                    Var.printVar();
                    break;
                case "sortvar":
                    Var.sortVar();
                    break;
                case "ru":
                    rm.setLocale(new Locale("ru", "RU"));
                    break;
                case "en":
                    rm.setLocale(new Locale("en", "US"));
                    break;
                case "be":
                    rm.setLocale(new Locale("be", "BY"));
                    break;
                default:
                    try {
                        Var result = parser.calc(line);

                        printer.print(result);
                    } catch (CalcException e) {

                        System.out.println(e.getMessage());
                         logger.toLog(e.getMessage());


                    }

            }}

        }
    }


