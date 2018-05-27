package by.it.kasiyanov.jd01_15;

import java.io.*;

public class TaskA {

    private static String dir (Class<?> cl){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName()
                .replace(cl.getSimpleName(),"")
                .replace(".",File.separator);
        return path + clDir;
    }

    public static String dir (String fileName){
        return dir(TaskA.class) + fileName;
    }

    public static void main(String[] args) {
        int [][] matrix = new int[6][4];
        for (int[] rows : matrix) {
            for (int i = 0; i < rows.length; i++) {
               rows[i] = (int)(Math.random()*31 - 15);
            }
        }

        try(PrintWriter writer = new PrintWriter(
                new FileWriter(dir(TaskA.class) + "matrix.txt"))
        ){
            for (int[] rows : matrix) {
                for (int i = 0; i < rows.length; i++) {
                    writer.printf("%3d ",rows[i]);
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(
                new FileReader(dir(TaskA.class) + "matrix.txt"))
        ) {
            while (reader.ready()){
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
