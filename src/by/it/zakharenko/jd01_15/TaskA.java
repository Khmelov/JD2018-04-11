package by.it.zakharenko.jd01_15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {


    private static String path(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    static String path(String filename) {
        return path(TaskA.class) + filename;
    }


    public static void main(String[] args) {
        int[][] mas = new int[6][4];
        for (int[] row : mas)
            for (int i = 0; i < row.length; i++)
                row[i] = -15 + (int) (Math.random() * 31);
        String filename = path("matrix.txt");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : mas) {
                for (int i = 0; i < row.length; i++)
                    printWriter.printf("%3d ", row[i]);
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            while (fileReader.ready())
                System.out.println(fileReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
