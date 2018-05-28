package by.it.shekh.jd01_15;

import java.io.*;
import java.util.Arrays;

/**
 * fsdfd
 */

public class TaskB {
    private static String path(Class<?> cl) {
        String rootProj = System.getProperty("user.dir") + File.separator + "src";
        String path = cl.getName().replaceAll(cl.getSimpleName(), "")
                .replace('.', File.separatorChar);
        return rootProj + File.separator + path;
    }

    private static String path(String filename) {
        return path(TaskA.class) + filename;//trer
    }

    public static void main(String[] args) {
        String filename = path("TaskB.java");/* fdsfdgdgdfgdgdf*/
        String fileWrite = path("TaskB.txt");
        //System.out.println(filename);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String tempLine = line;
                if (tempLine.contains("/" + "/")) {
                    char arCh[] = tempLine.toCharArray();
                    for (int i = 0; i < arCh.length; i++) {
                        if ((i + 1) < arCh.length && arCh[i] == '/' && arCh[i + 1] == '/') {
                            char temArCh[] = Arrays.copyOf(arCh, i);
                            if (temArCh.length != 0) {
                                tempLine = new String(temArCh);
                                sb.append(tempLine + "\n");
                            }
                        }
                    }
                } else if (tempLine.contains("/" + "*") && tempLine.contains("*" + "/")) {
                    char arCh[] = tempLine.toCharArray();
                    for (int i = 0; i < arCh.length; i++) {
                        if ((i + 1) < arCh.length && arCh[i] == '/' && arCh[i + 1] == '*') {
                            char temArCh[] = Arrays.copyOf(arCh, i);
                            if (temArCh.length != 0) {
                                tempLine = new String(temArCh);
                                sb.append(tempLine + "\n");
                            }
                        }
                    }
                } else if (tempLine.contains("/" + "*") && !tempLine.contains("*" + "/")) {
                    char arCh[] = tempLine.toCharArray();
                    for (int i = 0; i < arCh.length; i++) {
                        if ((i + 1) < arCh.length && arCh[i] == '/' && arCh[i + 1] == '*') {
                            char temArCh[] = Arrays.copyOf(arCh, i);
                            if (temArCh.length != 0) {
                                tempLine = new String(temArCh);
                                sb.append(tempLine);
                            }
                        }
                    }
                    while (reader.ready()) {
                        tempLine = reader.readLine();
                        if (tempLine.contains("*" + "/")) {
                            tempLine = new String("\n");
                            sb.append(tempLine);
                            break;
                        }
                    }
                } else
                    sb.append(tempLine + "\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();//Комент
        }
        try (PrintWriter writer = new PrintWriter(fileWrite)) {
            writer.print(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*
        d
        ds
        fdsfds
        d
         */
    }
}
