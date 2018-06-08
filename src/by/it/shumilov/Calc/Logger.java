package by.it.shumilov.Calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private SimpleDateFormat df=new SimpleDateFormat("dd.MM.yy HH:mm:ss.S");
    private static Logger instance;
    private Logger(){}

    static Logger getLogger(){
        if(instance == null)
            instance = new Logger();
        return instance;
    }

    void  logError( String error){
        try(PrintWriter pw = new PrintWriter(new FileWriter(path(Logger.class,"log.txt"), true))) {
            pw.println(String.format("%s %s",df.format(new Date()),error));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String path(Class<?> cl, String file){
        String[] a = cl.getPackage().getName().split("\\.");

        return  System.getProperty("user.dir") +File.separator+"src"+File.separator+String.join(File.separator,a) + File.separator + file;
    }

}
