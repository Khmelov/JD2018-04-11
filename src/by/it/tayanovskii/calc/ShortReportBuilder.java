package by.it.tayanovskii.calc;

import java.text.DateFormat;
import java.util.Date;

public class ShortReportBuilder extends ReportBuilder {
    DateFormat df = DateFormat.getDateTimeInstance(
            DateFormat.SHORT, DateFormat.SHORT);

    @Override
    public void addEvent(String event) {

        report.addToReport(event);
    }

    @Override
    public void addHead() {

        report.addToReport("--------------SHORT REPORT---------------------");
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

    }

}
