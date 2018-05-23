package by.it.shekh.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    private static List<String> fileList = new ArrayList<>();
    private static String SLASH = File.separator;

    private static String path(Class<?> cl) {
        String rootProj = System.getProperty("user.dir") + File.separator + "src";
        String path = cl.getName().replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return rootProj + File.separator + path;
    }

    private static String path(String filename) {
        return path(TaskA.class) + filename;
    }

    private static void fileLookUp(String path) {
        File file = new File(path);
        File[] str = file.listFiles();
        for (File s : str) {
            if (s.isDirectory()) {
                fileList.add("dir:" + s.getName());
                fileLookUp(s.getAbsolutePath());
            } else {
                fileList.add("file:" + s.getName());
            }
        }
    }

    private static void printResult(List<String> list) {
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(path("resultTaskC.txt")))) {
            for (String s : list) {
                System.out.println(s);
                printWriter.print(s + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + SLASH + "src" +
                SLASH + "by" + SLASH + "it" + SLASH + "shekh" + SLASH;
        fileList.add("dir:..");
        fileLookUp(path);
        printResult(fileList);

    }
}
