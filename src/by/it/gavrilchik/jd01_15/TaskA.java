package by.it.gavrilchik.jd01_15;

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

    private static String path(String filename) {

        return path(TaskA.class) + filename;
    }

    public static void main(String[] args) {
        int[][] mas = new int[6][4];
        String filename = path("matrix.txt");
        for (int[] row : mas) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + (int) (Math.random() * 31);
            }
        }

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : mas) {

                for (int j = 0; j < row.length; j++) {
                    printWriter.printf("%3d ", row[j]);
                }
                printWriter.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(filename)) {
            while (fileReader.ready())
                System.out.print((char) fileReader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



