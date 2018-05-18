package by.it.dkruchek.jd01_12;

import java.util.*;

/**
 * Created by Dmitriy.Kruchek on 5/16/2018.
 */
public class TaskB1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        Map<String, Integer> counter = new HashMap<>();

        while (! (s = sc.next()).equals("end")){
            s = s.replaceAll("[\\p{Punct}&&[^']]", "");
            if (! counter.containsKey(s)) counter.put(s, 1);
            else counter.put(s, counter.get(s) + 1);
        }
        System.out.println(counter);
    }
}
