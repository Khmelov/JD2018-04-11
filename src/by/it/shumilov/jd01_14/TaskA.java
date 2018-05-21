package by.it.shumilov.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static double sum= 0;
    private static int coun = 0;

    private  static  String path(Class<?> cl){
        String rootPrj = System.getProperty("user.dir") ;
        String path = cl.getName().replaceAll(cl.getSimpleName(),"").replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator +"src" + File.separator + path;
        return  path;
    }

    private static  String path(String fileName){
        return  path(TaskA.class) + fileName;
    }

    public static void main(String[] args) {
        //System.out.println(path("dataTaskA.bin"));
        String file1 = path("dataTaskA.bin");
        generateNums(20, file1);

        List<Integer> list = new ArrayList<Integer>();


        readFromFile(list,file1);

        printToFile(list,file1);


    }

    private  static  void printToFile(List<Integer> list,String path){
        try( PrintWriter pw = new PrintWriter(new FileWriter(path("resultTaskA.txt")))){
            for(Integer el:list){
                System.out.print(el+" ");
                pw.print(el+" ");
            }
            System.out.println();
            pw.print("\n");
            System.out.println("avg="+sum/coun);
            pw.print("avg="+sum/coun);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readFromFile(List<Integer> list,String path){


        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))) {
            while (dis.available()>0){
                int i = dis.readInt();
                list.add(i);
                sum+=i;
                coun++;

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static  void  generateNums(Integer col, String path){


        try (DataOutputStream dos = new DataOutputStream( new FileOutputStream(path))) {

            for (int i = 0; i < col; i++) {
                dos.writeInt((int)(Math.random()*(col+1)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
