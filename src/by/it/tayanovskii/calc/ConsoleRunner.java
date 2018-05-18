package by.it.tayanovskii.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(line = scanner.nextLine()).equals("end")){
            switch (line){
                case "printvar":
                {
                    Var.printvar();
                    break;

                }
                case  "sortvar":
                {
                    Var.sortvar();
                    break;

                }
                default: {
                    Var var = parser.calc(line);
                    printer.print(var);
                }
            }

        }
    }
}
