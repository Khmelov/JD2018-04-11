package by.it.shumilov.Calc;

public abstract class ReportBuilder {
    Report report;

    Report getReport(){return  report;}

    void createNewReport(){
        report = new Report();
    }

    public abstract void buildCaption();
    public abstract void buildTimeStart();
    public abstract void buildTimeEnd();

}
