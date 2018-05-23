package by.it.tayanovskii.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskC {


    public static void main(String[] args) {

        ArrayList <String> arrayList =new ArrayList<>();
        showDir(getPath(TaskC.class) + "..",arrayList);

        File p = new File(getPath("resultTaskC.txt"));
        if(p.exists())
                p.delete();

        printResult(arrayList, "resultTaskC.txt");

    }

    private static void printResult(ArrayList<String> arrayList, String nameFile) {
        try(PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(getPath(nameFile),true)))) {
            Iterator<String> iterator = arrayList.iterator();
            //iterator.next();
            while(iterator.hasNext())
            {
                String next = iterator.next();
                System.out.println(next);
                printWriter.println(next);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void showDir(String path, ArrayList<String> arrayList) {
            File p = new File(path);
            if (p.isFile()) {
                //System.out.println("file:" + p.getName());
                arrayList.add("file:" + p.getName());
            } else if (p.isDirectory()) {
                //System.out.println("dir:" + p.getName());
                arrayList.add("dir:" + p.getName());
                File[] paths = p.listFiles();
                if (paths != null)
                    for (File iterator : paths) {
                        showDir(iterator.getAbsolutePath(),arrayList);
                    }
            }

    }

    private static String getPath(Class<?> cl) {
        String rootPrj = System.getProperty("user.dir");
        String path = cl.getName()
                .replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator + "src" + File.separator + path;
        return path;
    }

    private static String getPath(String filename) {
        return getPath(TaskB.class) + filename;
    }


}