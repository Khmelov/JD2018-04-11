package by.it.zakharenko.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private Logger() {
    }

    private SimpleDateFormat data = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
    private static Logger instance;

    static Logger getLogger() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    void toLog(String message) {
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(getPath(Logger.class, "log.txt"), true))
        ) {
            printWriter.println(String.format("%s %s", data.format(new Date()), message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> cl, String file) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path + file;
    }
}
