package by.it.shekh.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private SimpleDateFormat df=new SimpleDateFormat("dd.MM.yy HH:mm:ss");
    private static Logger instance;
    private Logger(){}

    static Logger getLogger(){
        if(instance==null)
            instance=new Logger();
        return instance;
    }
    void errorLog(String error){
        try(PrintWriter pw=new PrintWriter(new FileWriter(path("log.txt"),true))) {
            pw.println(String.format("%s%s",df.format(new Date()),error));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static String path(Class<?> cl) {
        String rootProj = System.getProperty("user.dir") + File.separator + "src";
        String path = cl.getName().replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return rootProj + File.separator + path;
    }

    private static String path(String filename) {
        return path(Logger.class) + filename;//trer
    }
}
