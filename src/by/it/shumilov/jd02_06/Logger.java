package by.it.shumilov.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

    void  logError(String error){
        //Arrays.stream(File.listRoots()).map(a->a.getName()).peek(c-> System.out.println(c));
        System.out.println(File.pathSeparator);
        try(PrintWriter pw = new PrintWriter(new FileWriter("1.log", true))) {
            pw.println(String.format("%s %s",df.format(new Date()),error));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
