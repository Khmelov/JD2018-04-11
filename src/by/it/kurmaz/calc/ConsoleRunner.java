package by.it.kurmaz.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Printer printer = new Printer();
        Parser parser = new Parser();
        System.out.println("Recover variables database from last use? yes/no");
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("yes")) {
                try {
                    parser.recover();
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    Logger.Log(e.getMessage());
                }
                System.out.println("Enter a line to calculate, enter a variable, or type \"end\" to exit:");
                continue;
            }
            else if (line.equals("no")) {
                System.out.println("Enter a line to calculate, enter a variable, or type \"end\" to exit:");
                continue;
            }
            try {
                Var result = parser.calc(line);
                if (result == null)
                    printer.varPrint();
                else
                    printer.resultPrint(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                Logger.Log(e.getMessage());
            }
        }
        parser.save();
    }
}
