package by.it.tayanovskii.jd01_15;

import java.io.*;

/**
 * sdfsdf
 * sdfsdf
 * fdsdfs
 * sdfsd
 */
public class TaskB {
    public static void main(String[] args) {

        String fileName = TaskA.path("TaskB.java");
        System.out.println(fileName);
        StringBuilder stringBuilder=new StringBuilder(readFileAndDeleteComment(fileName));
        writeToFileAndConsole(fileName.replaceAll(".java", ".txt"), stringBuilder);

    }
    //Удаление комментария
    private static void writeToFileAndConsole(String fileName, StringBuilder stringBuilder) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            System.out.println(stringBuilder);
            writer.println(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * sdfsdf
     * sdfsdf
     * fdsdfs
     * sdfsd
     */
    private static StringBuilder readFileAndDeleteComment(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(
                        new FileReader(fileName));
        ) {
            while (reader.ready()) {
                char ch = (char) reader.read();
                sb.append(ch); //Привет
                int startIndex, endIndex;
                if ((startIndex = sb.indexOf("//")) > -1 && (endIndex = sb.indexOf("\n", startIndex)) > -1) {
                    sb.delete(startIndex, endIndex);
                }
                if ((startIndex = sb.indexOf("/*")) > -1 && (endIndex = sb.indexOf("*/", startIndex)) > -1) {
                    sb.delete(startIndex, endIndex + 2);
                }

            }
            /*
            fdsfsdfsdfsdf sd sdfsd
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}
/*
           fdsfsdfsdfsdf sd sdfsd
*/