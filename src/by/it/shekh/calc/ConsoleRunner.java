package by.it.shekh.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Printer printer = new Printer();
        Parser parser = new Parser();

        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            Var result = null;
            try {
                result = parser.calc(line);
                printer.Print(result);
            } catch (CalcException e){
                System.out.println(e.getMessage());
            }
        }


    }
}
