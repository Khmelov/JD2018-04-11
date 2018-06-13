package by.it.krivenkova.calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        VarFactory varFactory = new VarFactory();
        varFactory.getVar("18");
//        String line;
        Parser parser=new Parser();
        Printer printer=new Printer();

        File file = new File(Util.getPathVarsTxt());
        if (file.exists())
            try (BufferedReader reader = new BufferedReader(
                    new FileReader(file))
            ) {
                String line;
                while ((line = reader.readLine()) != null)
                    parser.calc(line);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CalcException e) {
                System.out.println(e);
            }

        Scanner sc = new Scanner(System.in);
        String line;


        Logger logger = Logger.getLogger();
        int iMes = 1;
        while (!(line = scanner.nextLine()).equals("end")){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println();

            logger.toLog("[Log "+iMes+"] "+ dateFormat.format(date) +"  "+  line);
            iMes++;
            Var var = null;
            try {
                var = parser.calc(line);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                logger.toLog("[Log "+iMes+"] ERROR "+ e);
            }
        }


    }
}
