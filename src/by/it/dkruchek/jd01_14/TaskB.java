package by.it.dkruchek.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy.Kruchek on 5/22/2018.
 */
public class TaskB {

    public static void main(String[] args) {


    String inputFile = "text.txt";
    String resultFile = "resultTaskB.txt";
    inputFile = TaskA.path(inputFile);
    resultFile = TaskA.path(resultFile);

    int words = 0, puctuationMarks = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(inputFile))){
        Pattern word = Pattern.compile("[а-яА-ЯёЁ]+");
        Pattern punct = Pattern.compile("[,.!?:;]");
        String line = br.readLine();
        while (line != null) {
            Matcher matherWords = word.matcher(line);
            while(matherWords.find()) words++;
            Matcher matherPunct = punct.matcher(line);
            while(matherPunct.find()) puctuationMarks++;
            line = br.readLine();
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    try (PrintWriter printWriter =
                 new PrintWriter(
                         new FileWriter(resultFile))) {
        printWriter.print("words=" + words + "marks=" + puctuationMarks);
        System.out.println("words=" + words + "marks=" + puctuationMarks);
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }
}
