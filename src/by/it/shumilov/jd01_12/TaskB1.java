package by.it.shumilov.jd01_12;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String, Integer> list = new HashMap<String, Integer>();
        String line;
        Pattern pt = Pattern.compile("([a-zA-z]+[-/']*[a-zA-z/']*)");

        while(!(line = sc.nextLine()).equals("end")){
            Matcher math = pt.matcher(line);
            while(math.find()){
                String word  = math.group();
                if (!list.containsKey(word)){
                    list.put(word, 1);
                }
                else {
                    list.put(word,list.get(word)+1);
                }

            }
        }
        System.out.println(list);
    }
}
