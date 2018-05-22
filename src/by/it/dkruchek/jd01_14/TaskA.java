package by.it.dkruchek.jd01_14;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy.Kruchek on 5/21/2018.
 */
/* DataInputStream - primitives
    ObjectInputStream - objects
 */
public class TaskA {

    private static String path(Class<?> cls){
        String prjRoot = System.getProperty("user.dir");
        String pkg = cls.getName()
                .replace(".", File.separator)
                .replaceAll(cls.getSimpleName(), "");
        return prjRoot +  File.separator + "src" + File.separator + pkg;
    }

    public static String path(String filename){
        return TaskA.path(TaskA.class) + filename;
    }

    public static void main(String[] args){

        String outputFile = "dataTaskA.bin";
        String resultFile = "resultTaskA.txt";
        outputFile = path(outputFile);
        resultFile = path(resultFile);

        // write to file
        try (DataOutputStream dos =
                     new DataOutputStream(
                             new FileOutputStream(outputFile))){
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random()*30));
            }
        }
        catch (IOException e){
            e.getStackTrace();
        }

        List<Integer> arrayList = new ArrayList<>();

        double sum = 0.0;
        int count = 0;

        // read from file
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(outputFile)))){
            while (dis.available() > 0){
                int i = dis.readInt();
                arrayList.add(i);
                sum += i;
                count++;
            }
        }
        catch (IOException e){
            e.getStackTrace();
        }

        // print output and write to file
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(resultFile))) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
                printWriter.print(integer + " ");

            }
            System.out.println("\navg=" + sum/count);
            printWriter.print("\navg=" + sum/count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\navg=" + sum/count);
    }
}
