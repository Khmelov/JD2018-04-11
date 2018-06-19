package by.it.tayanovskii.calc;

import java.io.*;
import java.util.Date;

public class Logger {
    private static volatile Logger instance;
    private String fileName;
    ReportBuilder reportBuilder;
    //StringBuilder messages =new StringBuilder();

    private Logger() {
        fileName = getPath(Logger.class, "Report.txt");
    }

    public static Logger getLogger() {
        Logger localInstance = instance;
        if (localInstance == null) {
            synchronized (Logger.class) {
                localInstance = instance;
                if (localInstance == null) instance = localInstance = new Logger();
            }
        }
        return localInstance;
    }

    public void setReportBuilder(ReportBuilder rb) {
        reportBuilder = rb;
    }

    public void addMessage(String message)
    {
        reportBuilder.addEvent(message);
    }

    public void addMessage(Exception ex)
    {
        reportBuilder.addEvent(ex);
    }


    void writeLogToFile ()
    {
        File p = new File(getPath(Logger.class,"Report.txt"));
        if(p.exists())
            p.delete();
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName,true)))) {
            writer.println(reportBuilder.report.getReport());
            System.out.println(reportBuilder.report.getReport());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private String getPath(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    private String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

}
