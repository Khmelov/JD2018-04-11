package by.it.tarasiuk.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String inputFile = "text.txt";
        String resultFile = "resultTaskB.txt";
        inputFile = TaskA.path(inputFile);
        resultFile = TaskA.path(resultFile);

        int words = 0, punctMarks = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            Pattern word = Pattern.compile("[а-яёА-ЯЁ]+");
            Pattern punct = Pattern.compile("[.,:;!?]");
            String line = bufferedReader.readLine();
            while (line != null) {
                Matcher matcherWords = word.matcher(line);
                while (matcherWords.find()) words++;
                Matcher matcherPunct = punct.matcher(line);
                while (matcherPunct.find()) punctMarks++;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter printWriter =
                     new PrintWriter(
                             new FileWriter(resultFile))) {
            printWriter.print("words=" + words + ", " + "punctuation marks=" + punctMarks);
            System.out.println("words=" + words + ", " + "punctuation marks=" + punctMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
