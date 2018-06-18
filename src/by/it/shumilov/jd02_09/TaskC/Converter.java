package by.it.shumilov.jd02_09.TaskC;

import java.io.*;

public abstract class Converter {

    private static Class<?> bean;




    private static String result = "";

    Converter(Class<?> bean){
        this.bean = bean;
    }

    Class<?> getBean()
    {
        return bean;
    }

    void setResult(String result){
        this.result = result;
    }

    void  save(File file){
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))){
            printWriter.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String getText(){
        return  result;
    }

    void load(String schema){}

    void  load(File file){}
}
