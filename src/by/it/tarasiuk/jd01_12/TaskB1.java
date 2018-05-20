package by.it.tarasiuk.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        HashMap<String, Integer> map = new HashMap<>();
        while (!(str = scanner.next()).equals("end")) {
            str = str.replaceAll("[\\p{Punct}&&[^-']]", "");
            if (!map.containsKey(str)) map.put(str, 1);
            else map.put(str, map.get(str) + 1);
        }
        System.out.println(map);
    }
}
