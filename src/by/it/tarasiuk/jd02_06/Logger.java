package by.it.tarasiuk.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yy HH:mm:ss:S");
    private static Logger logger;

    private Logger() {
    }

    static Logger getLogger() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    private static String filePath(Class<?> cl, String file) {
        String[] path = cl.getPackage().getName().split("\\.");
        return System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + String.join(File.separator, path)
                + File.separator + file;
    }

    void logError(String error) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath(Logger.class, "log.txt"), true))) {
            printWriter.println(String.format("%s %s", dateFormat.format(new Date()), error));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
