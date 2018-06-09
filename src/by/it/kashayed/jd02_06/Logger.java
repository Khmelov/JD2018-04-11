package by.it.kashayed.jd02_06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;

public class Logger {
    private Logger(){
    }
    private static Logger log;
    public static Logger getLogger(){
        if(log==null){
            log= new Logger();
        }
        return log;
    }
    public static String stringLog(String log){
        return log;
    }

    public static void main(String[] args) {
        Logger newlog = Logger.getLogger();
        Date date = new Date();
        //System.out.println(newlog);
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator
                +Logger.class.getName()
                .replace(".",File.separator)
                .replace(Logger.class.getSimpleName(),"");
        //System.out.println(path);
        PrintStream ps = null;
        try {
            ps = new PrintStream(path+"log.txt");
            String s= stringLog("ошибка");
            ps.println(date);
            ps.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ps.print(e);

        }
    }
}
