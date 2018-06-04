package by.it.tayanovskii.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static Map<String, Integer> words;

    public static void main(String[] args) {
        TaskB1 task = new TaskB1();
        words = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String str;
        StringBuilder strB = new StringBuilder();
        while (!(str=scanner.nextLine()).equals("end")) {
            strB.append(str);
        }
        wordsCount(strB);

    }

    static void wordsCount(StringBuilder strB) {
        Pattern pattern = Pattern.compile("\\w+('\\w)*");
        Matcher matcher = pattern.matcher(strB);
        while (matcher.find()) {
            String word = matcher.group();
            int count = words.getOrDefault(word, 0);
            words.put(word, count+1);
        }
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry);
        }


    }
}
