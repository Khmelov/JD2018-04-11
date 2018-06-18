package by.it.tarasiuk.calc;

import java.util.Scanner;

public class ConsoleRunner {
    static Logger logger = Logger.getLogger();

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(line = scanner.nextLine()).equals("end")) {
            try {
                Var var = parser.calc(line);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                logger.logError(e.getMessage());
            }
        }
    }
}
