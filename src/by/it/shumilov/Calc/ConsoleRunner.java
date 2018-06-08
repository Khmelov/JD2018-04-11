package by.it.shumilov.Calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args)  {
        Logger logger = Logger.getLogger();
        Scanner sc=new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        GetStr getStr = GetStr.getInstance();
        Locale locale = Locale.getDefault() ;

        logger.setStart();


        while (!(line = sc.nextLine().trim()).equals("end")){
            logger.logStartOperation(line);
            switch (line){
                case "ru": locale = new Locale(line,"RU");logger.logEndOperation("Смена языка на ru");continue; //break;
                case "be":locale = new Locale(line,"BY");logger.logEndOperation("Смена языка на be");continue;//break;
                case "en": locale = new Locale(line,"US");logger.logEndOperation("Смена языка на en");continue;// break;

            }
            getStr.setLocale(locale);

            Var var = null;



            try {

                var = parser.calc(line);
                printer.print(var);
                if(var == null)
                    logger.logEndOperation("Неправильнный ввод");
                else
                    logger.logEndOperation(var.toString());

            } catch (CalcException e) {
                logger.logEndOperation("Ошибка выполнения " + line);
                System.out.println(e.getMessage());
            }

        }
        logger.setFinish();

        Waiter waiter = new Waiter();
        ReportBuilder rb = (Math.random()>0.5) ? new LongReport() : new ShortReport();
        waiter.setReportBuilder(rb);
        waiter.constractReport();
        Report report = waiter.getReport();
        System.out.println(report);

    }

}
