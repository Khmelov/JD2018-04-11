package by.it.krivenkova.jd01_15;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        int mas[][] = new int[6][4];
        for (int[] row : mas) {
            for (int i = 0; i < row.length; i++) {
                row[i] = (int) (Math.random()*31) - 15;
            }
        }
        String filename = path("matrix.txt");

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))){
            for (int[] row : mas){
                for (int i = 0; i < row.length; i++)
                    printWriter.printf("%3d ", row[i]);

                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            while (fileReader.ready())
                System.out.println(fileReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String path(Class<?> cl){
        String rootPr = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(),"")
                .replace('.', File.separator.charAt(0));
        path = rootPr + File.separator + "src" + File.separator + path;
        return path;
    }

    static String path(String filename){
        return  path(TaskA.class)+ filename;
    }

}
