package by.it.shumilov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {

    public static void main (String[] args) {
        File file = new File(path());
        String[] files = file.list();
        for (String file1 : files) {
            System.out.println(file1);
        }

        getType(file);

        //printToFile("dir:"+ "..","resultTaskC.txt");



    }

    private static void getType(File file){
        File[] files = file.listFiles();

        for (File fil : files) {
            if(fil.isFile()){
                printToFile("file:"+ fil.getName(),"resultTaskC.txt");
                //System.out.println("file:"+ fil.getName());

            }
            else {
                //System.out.println("dir:"+ fil.getName());
                printToFile("dir:"+ fil.getName(),"resultTaskC.txt");
                getType(fil);
            }

        }
    }

    private  static  void printToFile(String s, String file){
        try( PrintWriter pw = new PrintWriter(new FileWriter(path(file),true))){

            System.out.println(s);
            pw.print(s+"\n");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private  static  String path(Class<?> cl){
        String rootPrj = System.getProperty("user.dir") ;
        String path = cl.getName().replaceAll(cl.getSimpleName(),"").replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator +"src" + File.separator + path;
        return  path;
    }

    private static  String path(String fileName){

        return  path(TaskC.class) + fileName;
    }


    private  static  String path(){
        String[] a = TaskC.class.getPackage().getName().split("\\.");
        a = Arrays.copyOf(a, a.length - 1);
        return  System.getProperty("user.dir") +File.separator+"src"+File.separator+String.join(File.separator,a) ;
    }

}
