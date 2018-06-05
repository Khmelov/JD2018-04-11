package by.it.rogov.calc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
//        parser.getWords("e={1,2,3}+1");
        Printer printer = new Printer();
        Log loger = new Log();
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new FileReader(Var.filename))
        ) {
            String s=null;
        while ((s=bufferedReader.readLine())!=null){
            parser.calc(s.trim());
        }

        } catch (CalcException | IOException e) {
            e.printStackTrace();
        }
        while (!(line = scanner.nextLine()).equals("end")) {
            try {
                Var var = null;
                loger.toLog(line);
                var = parser.calc(line);
                String string;
                if( (string=parser.getWords(line))!=null){
                    printer.print(var,string);
                }else
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
        ;
    }
}
