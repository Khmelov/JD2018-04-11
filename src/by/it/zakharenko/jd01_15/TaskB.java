package by.it.zakharenko.jd01_15;

import java.io.*;

/**
 * dfghj
 * werty
 * efgfp
 * hytgm
 */
public class TaskB {

    public static void main(String[] args) {

        String fileName = TaskA.path("TaskB.java");
        String fileNameTo = TaskA.path("TaskB.txt");
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader(fileName));
        ) {
            while (reader.ready()) {
                char ch = (char) reader.read();
                int start, finish;
                sb.append(ch);
                if ((start = sb.indexOf("//")) > -1 && (finish = sb.indexOf("\n", start)) > -1) {
                    sb.delete(start, finish);
                }
                if ((start = sb.indexOf("/*")) > -1 && (finish = sb.indexOf("*/", start)) > -1) {
                    sb.delete(start, finish + 2);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         fghbjn
        */

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(fileNameTo))) {
            writer.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
           ftgjkmn erdf
*/
