package by.it.kurmaz.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    private static PrintWriter writer;
    private static final String filename = "resultTaskC.txt";

    public static void main(String[] args) {

        Class cl = TaskC.class;
        File start = new File(getPath(cl) + "..");
        try {
            writer = new PrintWriter(new FileWriter(getPath(cl)+ filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printDir(start);
        writer.close();
    }

    private static void printDir(File source) {
        System.out.println("dir:" + source.getName());
        writer.write("dir:" + source.getName());
        File[] content = source.listFiles();
        if (content != null) {
            for (File element: content) {
                if (element.isDirectory())
                    printDir(element);
                else {
                    System.out.println("file:" + element.getName());
                    writer.write("file:" + element.getName());
                }
            }
        }
    }

    private static String getPath (Class cl) {
        String root = System.getProperty("user.dir");
        String path = cl.getName().replaceAll(cl.getSimpleName(), "").replace('.', File.separator.charAt(0));
        return root + File.separator + "src" + File.separator + path;
    }

}
