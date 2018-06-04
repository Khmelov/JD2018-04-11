package by.it.shumilov.jd01_15;

import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        int[][] mas = new int[6][4];
        String path = path("matrix.txt");

        for (int[] el : mas) {
            for (int i = 0; i < el.length; i++) {
                el[i] = (int)(Math.random()*31) - 15;
            }
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(path))){

            for (int[] el : mas) {
                for (int i = 0; i < el.length; i++) {
                    pw.printf("%3d ",el[i]);
                }
                pw.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {
           while (br.ready())
               System.out.println(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private  static  String path(Class<?> cl){
        String rootPrj = System.getProperty("user.dir") ;
        String path = cl.getName().replaceAll(cl.getSimpleName(),"").replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator +"src" + File.separator + path;
        return  path;
    }

    public static  String path(String fileName){
        return  path(TaskA.class) + fileName;
    }
}
