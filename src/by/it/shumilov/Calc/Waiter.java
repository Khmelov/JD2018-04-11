package by.it.shumilov.Calc;

public class Waiter {
    private ReportBuilder reportBuilder;

    void setReportBuilder(ReportBuilder rb){
        reportBuilder = rb;
    }

    Report getReport(){
        return reportBuilder.getReport();
    }
    void  constractReport(){
        reportBuilder.createNewReport();
        reportBuilder.buildCaption();
        reportBuilder.buildTimeStart();
        reportBuilder.buildTimeEnd();
    }
}
