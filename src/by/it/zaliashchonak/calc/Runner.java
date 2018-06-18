package by.it.zaliashchonak.calc;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        Printer printer = Printer.getInstance();

        while (!(line = scanner.nextLine()).equals("end")){
            Var var = null;
            try {
                var = parser.calc(line);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
