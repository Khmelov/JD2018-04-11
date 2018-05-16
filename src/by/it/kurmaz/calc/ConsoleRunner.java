package by.it.kurmaz.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Printer printer = new Printer();
        Parser parser = new Parser();
        System.out.println("Enter a line to calculate, or type \"end\" to exit:");
        while (!(line = scanner.nextLine()).equals("end")) {
            Var result = parser.calc(line);
            if (result == null)
                printer.varPrint();
            else
                printer.resultPrint(result);
        }
    }
}
