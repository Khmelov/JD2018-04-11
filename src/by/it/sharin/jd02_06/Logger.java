package by.it.sharin.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private static Logger instance;

    private Logger() {}

    static Logger getLogger() {
        if (instance == null)
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        return instance;
    }


    void logMessage(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(logPath(Logger.class, "log.txt"), true))) {
            printWriter.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String logPath(Class<?> cl, String str){
        String[] arr = cl.getPackage().getName().split("\\.");
        return  System.getProperty("user.dir") +File.separator+"src"+File.separator+String.join(File.separator,arr) + File.separator + str;
    }
}
