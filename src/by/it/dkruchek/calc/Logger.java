package by.it.dkruchek.calc;

import java.io.*;
import java.util.Date;

class Logger {

    private static Logger instance;
    private String logName;

    private Logger(){
        logName = path("log.txt");
    };

    static Logger getLogger(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    private static String path(Class<?> cls){
        String prjRoot = System.getProperty("user.dir");
        String pkg = cls.getName()
                .replace(".", File.separator)
                .replaceAll(cls.getSimpleName(), "");
        return prjRoot +  File.separator + "src" + File.separator + pkg;
    }

    public static String path(String filename){
        return path(Logger.class) + filename;
    }

    void log(String message, LogLevel level){
        String msg = null;
        BufferedWriter bw = null;
        Date currentDate = new Date();
        //DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, rm.getLocale());
        switch(level) {
            case INFO:
                msg = String.format("%s  [%s]  %s", currentDate, "INFO", message);
                break;
            case ERROR:
                msg = String.format("%s  [%s]  %s", currentDate, "ERROR", message);
                break;
        }
        try {
            bw = new BufferedWriter(new FileWriter(logName,true));
            bw.write(msg);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

enum LogLevel{
    INFO,
    ERROR
}
