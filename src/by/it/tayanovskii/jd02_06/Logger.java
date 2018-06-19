package by.it.tayanovskii.jd02_06;

import java.io.*;
import java.util.Date;

public class Logger {
    private static volatile Logger instance;
    private String fileName;
    private Logger(){
        fileName=getPath(Logger.class,"log.txt");
    }

    public static Logger getLogger()
    {
        Logger localInstance = instance;
        if (localInstance==null)
        {
            synchronized (Logger.class)
            {
                localInstance=instance;
                if(localInstance==null) instance=localInstance=new Logger();
            }
        }
        return localInstance;
    }

    void writeLogToFile (String event)
    {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName,true)))) {
            writer.println(event);
            System.out.println(getDate()+ "  " + event);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDate()
    {
        return new Date().toString();

    }

    private String getPath(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    private String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

}
