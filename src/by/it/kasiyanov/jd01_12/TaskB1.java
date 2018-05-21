package by.it.kasiyanov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word;
        String pattern = "[/,;\":—()!\\?\\.]";

        Map<String, Integer> list = new HashMap<>();

        while (!((word = scan.next()).equals("end"))){
            word = word.replaceAll(pattern, "");


            if (list.containsKey(word)) {
                list.put(word, list.get(word) + 1);
            }
            else if (word.equals("")){
            }else list.put(word, 1);
        }
        for (String value : list.keySet()) {
            System.out.println(value + "=" + list.get(value));
        }



    }
}
