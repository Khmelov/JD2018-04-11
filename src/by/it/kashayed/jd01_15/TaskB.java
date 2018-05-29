package by.it.kashayed.jd01_15;

import java.io.*;

/**
 * If you want to create your future you must work now
 * or
 * you should have rich parents)
 */

public class TaskB {

    /*I
    will
    like
    my
    future
    job*/
    private static String str (Class<?> cls){
        String name = cls.getName().replace(cls.getSimpleName(),"").replace(".", File.separator);
        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator;
        return path+name;
    }
    //this is a comment

    public static void main(String[] args) {
        File file = new File(str(TaskB.class)+"TaskB.java");
        System.out.println(file);
        StringBuilder sb = new StringBuilder();            //and it is a comment
        DataInputStream br = null;
        try {br =new DataInputStream(new BufferedInputStream(
                            new FileInputStream(file)));
            PrintStream printStream =
                    new PrintStream(
                            new FileOutputStream(str(TaskB.class)+"TaskB.txt"));

            while(br.available()>0){
                String s = br.readLine();
                Formating.formating(s,printStream);
                sb.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            /*I
            was
            here
             */

    }
}
