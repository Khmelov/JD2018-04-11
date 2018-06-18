package by.it.tayanovskii.calc;

import java.text.DateFormat;
import java.util.Date;

public class LongReportBuilder extends ReportBuilder {
    DateFormat df =  DateFormat.getDateTimeInstance(
            DateFormat.LONG, DateFormat.LONG);

    @Override
    public void addEvent(String event) {

        report.addToReport(event);
    }

    @Override
    public void addHead() {

        report.addToReport("--------------LONG REPORT---------------------");
    }

    @Override
    public void addStartTime() {

        String date = df.format(new Date());
        report.addToReport(date);

    }

    @Override
    public void addEndTime() {
        String date = df.format(new Date());
        report.addToReport(date);
    }

    @Override
    public void addEvent(Exception ex) {
        report.addToReport(ex.getMessage());
        for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
            report.addToReport(stackTraceElement.toString());
        }
    }
}
