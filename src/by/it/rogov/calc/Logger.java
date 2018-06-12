package by.it.rogov.calc;



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger {

    private static String filename;
    private static List<String> logList = new ArrayList<>();
    private static Logger instance;
    private static DateFormat dataFormat=DateFormat.getDateInstance();

    private Logger() {
        filename = Path.path("log.txt");
    }

    public static Logger getInstans() {
        if (instance == null) {
            return instance = new Logger();
        }
        return instance;
    }

    public void toLog(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            logList.add(dataFormat.format(new Date())+" "+message );
            for (String s : logList) {
                printWriter.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
