package by.it.shumilov.Calc;

public class LongReport extends ReportBuilder {
    @Override
    public void buildCaption() {
        report.setCaption("Caption Long");
    }

    @Override
    public void buildTimeStart() {
        report.setTimeStart("Start");
    }

    @Override
    public void buildTimeEnd() {
        report.setTimeEnd("End");
    }
}
