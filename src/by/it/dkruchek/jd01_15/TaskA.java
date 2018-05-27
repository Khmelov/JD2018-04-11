package by.it.dkruchek.jd01_15;

import java.io.*;

/**
 * Created by Dmitriy.Kruchek on 5/23/2018.
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
        return path(TaskA.class) + filename;
    }

    public static void main(String[] args) {

        int[][] matrix =new int[6][4];

        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -15 + (int)(Math.random()*31);
            }
        }
        String filename = path("matrix.txt");
        try (PrintWriter writer = (new PrintWriter(
                new FileWriter(filename)))){
            for (int[] row : matrix) {
                for (int i = 0; i < row.length; i++) {
                    writer.printf("%3d ", row[i]);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(filename))){
            String line;
            while ((line = br.readLine())!=null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
