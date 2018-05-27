package by.it.tarasiuk.jd01_15;

import java.io.*;

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
        int[][] intMatrix = new int[6][4];
        for (int[] row : intMatrix)
            for (int i = 0; i < row.length; i++)
                row[i] = (-15 + (int) (Math.random() * 31));
        String filename = path("matrix.txt");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : intMatrix) {
                for (int i = 0; i < row.length; i++)
                    printWriter.printf("%3d ", row[i]);
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
