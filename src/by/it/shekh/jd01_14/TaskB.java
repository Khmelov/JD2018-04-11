package by.it.shekh.jd01_14;

import java.io.*;
import java.util.List;

public class TaskB {
    private static String path(Class<?> cl) {
        String rootProj = System.getProperty("user.dir") + File.separator + "src";
        String path = cl.getName().replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return rootProj + File.separator + path;
    }

    private static String path(String filename) {
        return path(TaskA.class) + filename;
    }

    private static String readTxtFile(String filename) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(filename))
        ) {
            String line;
            StringBuffer sb = new StringBuffer();
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static void printResult(String str) {
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(path("resultTaskB.txt")))) {

            String worArr[] = str.split("[\\s?!,.\\n:;-]+");
            String newStr = str.replaceAll("[\\s]+", "");
            String punArr[] = null;
            punArr = newStr.trim().split("[А-Яа-яЁё]+");
            System.out.println("words=" + worArr.length + ", punctuation marks=" + (punArr.length - 1));
            printWriter.println("words=" + worArr.length + ", punctuation marks=" + (punArr.length - 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fname = path("TaskB.txt");
        String fStr = "";
        fStr = readTxtFile(fname);
        printResult(fStr);
    }
}
