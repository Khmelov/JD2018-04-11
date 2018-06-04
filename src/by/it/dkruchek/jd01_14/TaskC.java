package by.it.dkruchek.jd01_14;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Dmitriy.Kruchek on 5/22/2018.
 */
public class TaskC {
    static void listDir(String path, PrintWriter writer) throws FileNotFoundException{
        File directory = new File(path);
        if (directory.isFile()) {
            System.out.println("file:" + directory.getName());
            writer.println("file:" + directory.getName());
        }
        if (directory.isDirectory()) {
            System.out.println("dir:" + directory.getName());
            writer.println("dir:" + directory.getName());

            File subFiles[] = directory.listFiles();
            if (subFiles != null){
                for (File subFile : subFiles) {
                    listDir(subFile.getAbsolutePath(), writer);
                }
            }
        }
    }
    public static void main(String[] args) {
        String resultFile = "resultTaskC.txt";
        resultFile = TaskA.path(resultFile);
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" + File.separator + "dkruchek";

        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(resultFile))) {
            printWriter.println("dir:.");
            System.out.println("dir:.");
            printWriter.println("dir:..");
            System.out.println("dir:..");
            listDir(path, printWriter);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
