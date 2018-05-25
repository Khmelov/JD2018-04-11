package by.it.kasiyanov.jd01_15;

import java.io.*;
//one line comment

/**
 * javaDoc
 * javaDoc
 * javaDoc
 * javaDoc
 */

public class TaskB {
    public static void main(String[] args) {
        //one line comment

        String fileName = TaskA.dir("TaskB.java");
        String fileNameWrite = TaskA.dir("TaskB.txt");

        /*multiline comment
        multiline comment
        multiline comment*/

        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(
                new FileReader(fileName))
            /*multiline comment*/
        ) {
            while (reader.ready()){
                String line = reader.readLine();
                String tmp = line.trim();
                if (tmp.startsWith("/" + "/") || (tmp.startsWith("/" + "*") && tmp.endsWith("*" + "/"))){
                }
                else if (tmp.startsWith("/" + "*")){
                    while (reader.ready()){
                        line = reader.readLine();
                        tmp = line.trim();
                        if (tmp.endsWith("*" + "/")){
                            break;
                        }
                    }
                } else {
                    sb = sb.append(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb);

        try(PrintWriter writer = new PrintWriter(fileNameWrite)){
            writer.print(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
