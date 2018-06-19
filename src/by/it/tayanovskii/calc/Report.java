package by.it.tayanovskii.calc;

public class Report {
    Report() {
       report = new StringBuilder();
    }
    private StringBuilder report;

    void addToReport(String event) {
        report.append(event).append("\n");
    }

    String getReport()
    {
        return report.toString();
    }
}
