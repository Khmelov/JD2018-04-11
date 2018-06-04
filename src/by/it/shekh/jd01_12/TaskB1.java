package by.it.shekh.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = Test_jd01_12.text.trim();
        String strArr[] = str.split("[\\s.,:;!?-]+");
        Map<String, Integer> words = new HashMap<>();
        for (String w:strArr){
            if(words.get(w)==null) words.put(w,1);
            else words.put(w,words.get(w)+1);
        }
        for (Map.Entry<String,Integer> stringIntegerEntry : words.entrySet()){
            System.out.println(stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue());
        }
    }
}
