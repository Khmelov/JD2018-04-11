package by.it.zakharenko.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s;
        StringBuilder sb = new StringBuilder();
        List<String> text = new ArrayList<>();
        HashMap<String, Integer> frequency = new HashMap<>();
        while (!(s = scanner.next()).equals("end"))
            sb.append(s).append(" ");
        Matcher m = Pattern.compile("[A-Za-z']+").matcher(sb);
        while (m.find())
            text.add(m.group());

            for (String word : text) {
            if (!frequency.containsKey(word)) {  //проверяет, существует ли элемент с ключом word
                frequency.put(word, 0);
            }
            frequency.put(word, Collections.frequency(text, word));
        }

        for (String word : frequency.keySet()) {
            System.out.println(word + "=" + frequency.get(word));
        }

    }
}
