package by.it.kashayed.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line=scanner.nextLine()).equals("end")){
//            if((line=scanner.nextLine()).equals("printvar")){
//
//            }

            try {
                Var result = parser.calc(line.trim());
                printer.print(result);
            } catch (CalcExeption calcExeption) {
                System.out.println(calcExeption.getMessage());
            }

        }
    }
}
