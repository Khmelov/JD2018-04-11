package by.it.kashayed.jd02_04.jd02_04new;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line=scanner.nextLine()).equals("end")){
            try {
                Var result = parser.calc(line.trim());
                printer.print(result);
            } catch (CalcException err) {
                System.out.println(err.getMessage());
            }

        }
    }
}
