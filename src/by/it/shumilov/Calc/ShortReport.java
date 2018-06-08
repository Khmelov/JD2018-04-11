package by.it.shumilov.Calc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ShortReport extends ReportBuilder{
    Logger logger = Logger.getLogger();
    private SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss.S");

    @Override
    public void buildCaption() {

        report.setCaption("The report on the done work (Short)");
    }

    @Override
    public void buildTime() {

        report.setTime( "Выполнение началось в " + df.format(logger.getStart()) + " и закончилось в " +  df.format(logger.getFinish()));
    }

    @Override
    public void buildOperations() {
        LinkedList<LinkedList<String>> operations = logger.getOperations();
        StringBuilder sb = new StringBuilder();

        for (LinkedList<String> operation : operations) {
            sb.append("Произведена операция: " + operation.removeFirst() + "\n");
            sb.append("           Результат: " + operation.removeLast() + "\n");
        }

        report.setOperations(sb.toString());
    }
}
