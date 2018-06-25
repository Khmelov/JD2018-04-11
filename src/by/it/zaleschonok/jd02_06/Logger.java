package by.it.zaleschonok.jd02_06;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance;
    private String path = System.getProperty("user.dir")+"\\src\\by\\it\\zaleschonok\\jd02_06\\";
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
    private Date dateNow = new Date();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

    private Logger() {

    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        try {
            for (int i = 0; i < 5; i++) {
                String line = "line ";
                System.out.println(line + i);
                logger.logWrite(line + i);
            }

            int n = 2/0;
            logger.logWrite(Integer.valueOf(n).toString());
        } catch (Exception e) {
            logger.logWrite(e.getMessage());
        }
    }

    private static Logger getLogger() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void logWrite(String text) {
        String fileName = "log.txt";
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(
                        new File(path, fileName), true))
        ) {
            bw.write(formatForDateNow.format(dateNow) + " - " + text + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}