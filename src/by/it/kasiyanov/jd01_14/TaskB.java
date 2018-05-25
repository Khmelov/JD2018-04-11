package by.it.kasiyanov.jd01_14;

import java.io.*;

public class TaskB {
    private static String dir (Class<?> cl){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName()
                .replace(cl.getSimpleName(),"")
                .replace(".",File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        StringBuilder words = new StringBuilder();
        StringBuilder marks = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(
                new FileReader(dir(TaskB.class) + "TaskB.txt"))
        ) {
            while (reader.ready()) {
                String line = reader.readLine();
                marks = marks.append(line.replaceAll("[а-яёА-ЯЁ]", "").trim() + " ");
                words = words.append(line.replaceAll("[\\p{Punct})]", "") + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] wordsCount = words.toString().split("[ ]+");
        String[] marksCount = marks.toString().split("[ ]+");

        try(PrintWriter writer = new PrintWriter(
                new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))
        ){
            writer.println("words=" + wordsCount.length + ", " + "punctuation marks=" + marksCount.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("words=" + wordsCount.length + ", " + "punctuation marks=" + marksCount.length);
    }
}
