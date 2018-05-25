package by.it.kurmaz.jd01_15;

import java.io.*;

public class TaskA {

    private static String path (Class<?> cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = -15 + (int) (Math.random()*31);
            }
        }

        Class cl = TaskA.class;

        try(PrintWriter writer = new PrintWriter(new FileWriter(path(cl)+ "matrix.txt"))) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    writer.printf("%3d ", matrix[i][j]);
                }
                writer.println();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(path(cl)+ "matrix.txt"))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
