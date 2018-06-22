package by.it.zaleschonok.jd01_15;

import java.io.*;


public class TaskB {
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }

    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }

    public static void main(String[] args) {

//        Коммент 1
//        Коммент 2
        /*        Коммент 3(многострочный)         */
        /*        Коммент 4 (многострочный)      */
        /**       Коммент 5 (JavaDoc многострочный)*/

        StringBuilder sb = new StringBuilder();
        String pathJava = getPath(TaskB.class,"TaskB.java");
        System.out.println(pathJava);
        String pathTxt = getPath(TaskB.class, "TaskB.txt");
        System.out.println(pathTxt);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(pathJava))) {
            while ((line = br.readLine()) != null) sb.append(line).append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        int startIndex, endIndex;
        while ((startIndex = sb.indexOf("\u002f*")) >= 0 && (endIndex = sb.indexOf("*\u002f")) >= 0) {
            sb.delete(startIndex, endIndex + 2);
        }
        while ((startIndex = sb.indexOf("\u002f/")) >= 0 && (endIndex = sb.indexOf("\n", startIndex)) >= 0) {
            sb.delete(startIndex, endIndex);
        }
        try (PrintWriter printer = new PrintWriter(new FileWriter(pathTxt))) {
            printer.print(sb);
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}