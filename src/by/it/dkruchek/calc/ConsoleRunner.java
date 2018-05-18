package by.it.dkruchek.calc;

import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")){
            Var result = parser.calc(line);
            printer.print(result);
        }
    }
}
