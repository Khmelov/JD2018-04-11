package by.it.shumilov.Calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Logger {

    private LinkedList<LinkedList<String>> operations  = new LinkedList<>();
    private LinkedList<String> listOperations;

    private Date start;
    private Date finish;

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

    void logStartOperation(String exeption){
        listOperations = new LinkedList<>();
        listOperations.addLast(exeption);
    }

    void logOperation(String op){
        listOperations.addLast(op);
        //operations.addLast(String.format("%s %s %s",df.format(new Date()),"operation",op));
    }

    void logEndOperation(String res) {
        listOperations.addLast(res);
        operations.addLast(listOperations);
    }

    LinkedList<LinkedList<String>> getOperations() {
        return operations;
    }

    private static String path(Class<?> cl, String file){
        String[] a = cl.getPackage().getName().split("\\.");

        return  System.getProperty("user.dir") +File.separator+"src"+File.separator+String.join(File.separator,a) + File.separator + file;
    }

    public Date getStart() {
        return start;
    }

    public void setStart() {
        this.start = new Date();
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish() {
        this.finish = new Date();
    }
}
