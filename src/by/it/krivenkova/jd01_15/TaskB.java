package by.it.krivenkova.jd01_15;

import java.io.*;

/**
 * tetr
 * dfgdf
 * 798tu
*/
public class TaskB {
    public static void main(String[] args) {
        String filename = path(TaskB.class, "TaskB.java");
        String fileOutput = path(TaskB.class,"TaskB.txt");
        System.out.println("fileOutput  " + fileOutput);
        System.out.println(filename);
        StringBuilder sb = new StringBuilder();

//comment

        /*
sssdfd
 */

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line=reader.readLine())!=null) sb.append(line).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        int startIndex, endIndex;
        while ((startIndex=sb.indexOf("\u002f*")) >= 0 && (endIndex=sb.indexOf("*\u002f")) >=0 ){
            sb.delete(startIndex, endIndex+2);
        }
        while ((startIndex=sb.indexOf("\u002f/")) >= 0 && (endIndex=sb.indexOf("\n",startIndex))>=0){
            sb.delete(startIndex, endIndex);
        }
        try(PrintWriter printer = new PrintWriter(new FileWriter(fileOutput))){
            printer.print(sb);
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
                     /*
             ejtejwoidgsp etket;
           */
        }

    }



    private static String path(Class<?> cl){
        String path = System.getProperty("user.dir");
        path +=  File.separator + "src" + File.separator;
        path += cl.getName()
                .replaceAll(cl.getSimpleName(),"")
                .replace(".", File.separator);
        return path;
    }

    static String path(Class<?>cl, String filename){
        return  path(cl)+ filename;
    }

}
//end

