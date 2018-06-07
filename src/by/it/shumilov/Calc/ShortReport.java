package by.it.shumilov.Calc;

public class ShortReport extends ReportBuilder{


    @Override
    public void buildCaption() {
        report.setCaption("Caption");
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
