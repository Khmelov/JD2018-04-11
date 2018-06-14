package by.it.lanevich.calc3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {

    private String filename;


    private Logger() {
        filename = getPath(Logger.class, "log.txt");
    }

    private static Logger instance;

    static Logger getLogger() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    void toLog(String message) {
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(filename, true))
        ) {
            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            printWriter.println(formatForDateNow.format(date)+"  "+message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

}