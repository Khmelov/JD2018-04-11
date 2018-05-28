package by.it.shekh.jd01_15;

import java.io.*;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        int[][] matr = new int[6][4];
        for (int[] r : matr) {
            for (int i = 0; i < r.length; i++) {
                r[i] = -15 + (int) (Math.random() * 31);
            }
        }
        String filename = path("filename.txt");
        System.out.println(filename);
        printResult(matr);
        readIntFile(path("matrix.txt"));
    }

    private static void printResult(int[][] a) {
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(path("matrix.txt")))) {
            for (int[] r : a) {
                for (int i = 0; i < r.length; i++) {
                    printWriter.printf("%3d ", r[i]);
                }
                printWriter.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readIntFile(String filename) {
        try (
                BufferedReader bufre = new BufferedReader(new FileReader(filename))) {

            while (bufre.ready()) {
                System.out.print(bufre.readLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String path(Class<?> cl) {
        String rootProj = System.getProperty("user.dir") + File.separator + "src";
        String path = cl.getName().replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return rootProj + File.separator + path;
    }

    private static String path(String filename) {
        return path(TaskA.class) + filename;
    }
}
