package by.it.kashayed.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TaskA {

    private static String str (Class<?> cls){
        String name = cls.getName().replace(cls.getSimpleName(),"").replace(".", File.separator);
        String path=System.getProperty("user.dir")+File.separator+"src"+File.separator;
        return path+name;
    }
    public static void main(String[] args) {
        System.out.println(str(TaskA.class));
        DataOutputStream dataOutputStream= null;
        try{
            dataOutputStream =
                         new DataOutputStream(
                                 new BufferedOutputStream(
                                         new FileOutputStream(str(TaskA.class)+"dataTaskA.bin")));

            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int)(Math.random()*20));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (dataOutputStream!=null){
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       // List <Integer> list = new ArrayList<>();
        try (DataInputStream dataInputStream =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(str(TaskA.class)+"dataTaskA.bin")));
             PrintWriter printw = new PrintWriter(new FileWriter(str(TaskA.class)+"resultTaskA.txt"))
        ){
            double sum = 0;
            int count=0;
            while(dataInputStream.available()>0){
          //  list.add(dataInputStream.readInt());
             int i = dataInputStream.readInt();
             System.out.print(i+" ");
            sum+=i;
            count++;
            printw.print(i+" ");
            }
            System.out.println("\navg="+sum/count);
            printw.print("\navg="+sum/count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
