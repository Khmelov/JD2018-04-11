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
                    Variables.recover();
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    Logger.Log(e.getMessage());
                }
                System.out.println("Enter a line to calculate, enter a variable, or type \"end\" to exit:");
                continue;
            }
            else if (line.equals("no")) {
                System.out.println("Enter a line to calculate, type \"printvar\", \"sortvar\"  or type \"end\" to exit:");
                continue;
            }
            //line.split("(\\(.+\\))*?");
            if (line.contains(Patterns.PRINTVAR)) {
                Variables.printHash();
                continue;
            }
            else if (line.contains(Patterns.SORTVAR)) {
                Variables.printSort();
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
