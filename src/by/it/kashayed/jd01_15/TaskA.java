package by.it.kashayed.jd01_15;


import java.io.*;

public class TaskA {

    private static String str (Class<?> cls){
        String name = cls.getName().replace(cls.getSimpleName(),"").replace(".", File.separator);
        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator;
        return path+name;
    }

    public static void main(String[] args) {
        int [][] mas = new int[6][4];
        for (int[] ma : mas) {
            for (int i = 0; i < ma.length; i++) {
                ma[i]=(int)(-15+Math.random()*31);
            }

        }
//        for (int[] ma : mas) {
////            for (int i = 0; i < ma.length; i++) {
////                System.out.print(ma[i]+" ");
////            }
////            System.out.println();
////        }
////        System.out.println();
////        for (int i = 0; i < mas.length; i++) {
////            for (int j = 0; j < mas[i].length; j++) {
////                System.out.print(mas[i][j]+" ");
////            }
////            System.out.println();
////        }
        System.out.println(str(TaskA.class));
        try (PrintWriter printw = new PrintWriter(new FileWriter(str(TaskA.class)+"matrix.txt")))
        {
                int f=0;
                for (int i = 0; i < mas.length; i++) {
                    for (int j = 0; j < mas[i].length; j++) {
                        f = mas[i][j];
                        System.out.printf("%-3d ",f);
                        printw.printf("%-3d ",f);
                    }
                    System.out.println();
                    printw.println("");
                }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
