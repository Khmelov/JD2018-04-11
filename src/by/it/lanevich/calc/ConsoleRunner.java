package by.it.lanevich.calc;

import java.util.Map;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String line;

        Parser parser=new Parser();
        Printer printer=new Printer();

        while(!(line=scan.nextLine()).equals("end")){
            if(line.equals("printvar"))
            Var.printVar();
            if(line.equals("sortvar"))
                Var.sortVar();

          try {
              Var result = parser.calc(line);
              printer.print(result);
            } catch (CalcException e){
              System.out.println(e.getMessage());
            }


        }
    }

}
