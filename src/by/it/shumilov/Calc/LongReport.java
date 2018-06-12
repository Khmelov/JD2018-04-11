package by.it.shumilov.Calc;

import java.text.SimpleDateFormat;
import java.util.LinkedList;

public class LongReport extends ReportBuilder {
    private SimpleDateFormat df=new SimpleDateFormat("dd.MM.yy HH:mm:ss.S");
    Logger logger = Logger.getLogger();


    @Override
    public void buildCaption() {
        report.setCaption("The report on the done work (Long)");
    }

    @Override
    public void buildTime() {

        report.setTime( "Выполнение началось " + df.format(logger.getStart()) + " и закончилось " +  df.format(logger.getFinish()));
    }

    @Override
    public void buildOperations() {
        LinkedList<LinkedList<String>> operations = logger.getOperations();
        StringBuilder sb = new StringBuilder();

        for (LinkedList<String> operation : operations) {
            sb.append("   Произведена операция: " + operation.removeFirst() + "\n");
            int size = operation.size()-1;
            for (int i = 0; i < size; i++) {
                sb.append("Промежуточный результат: " + operation.removeFirst() + "\n");
            }
            sb.append("              Результат: " + operation.removeFirst() + "\n");
        }

        report.setOperations(sb.toString());
    }
}
