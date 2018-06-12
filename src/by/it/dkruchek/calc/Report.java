package by.it.dkruchek.calc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {
    private String Header;
    private Date startDate;
    private Date endDate;
    private List<String> operationsReport = new ArrayList<>();

    public void setHeader(String header) {
        Header = header;
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    void setEndDate(Date endtDate) {
        this.endDate = endtDate;
    }

    void addOperationToReport(String operation) {
        this.operationsReport.add(operation);
    }

    public String getHeader() {
        return Header;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public List<String> getOperationsReport() {
        return operationsReport;
    }
}

class ReportBuilder{
    private Report report;
    private ReportBuilder instance;
    Boolean extendedReport;

    ReportBuilder(Boolean extendedReport){
        this.extendedReport = extendedReport;
        report = new Report();
    }

//    public ReportBuilder getReportBuilder(Boolean extendedReport) {
//        if(instance == null){
//            instance = new ReportBuilder(extendedReport);
//        }
//        return instance;
//    }

    public void buildHeader(String header){
        report.setHeader(header);
    }

    public void buildStartDate(){
        Date startDate = new Date();
        report.setStartDate(startDate);
    }

    public void buildEndDate(){
        Date endDate = new Date();
        report.setEndDate(endDate);
    }

    public void buildOperation(String operation){
        report.addOperationToReport(operation);
    }

    public void buildException(Exception exception){
        if (extendedReport)
            report.addOperationToReport(exception.getMessage());
        else report.addOperationToReport(exception.getClass().getSimpleName());
    }

    void printReport(){
        buildHeader("--Calc Report--");
        System.out.println(report.getHeader());
        System.out.printf("Started at: %s\n", report.getStartDate());
        for (String operation : report.getOperationsReport()) {
            System.out.println(operation);
        }
        System.out.printf("Finished at: %s\n", report.getEndDate());
    }
}

