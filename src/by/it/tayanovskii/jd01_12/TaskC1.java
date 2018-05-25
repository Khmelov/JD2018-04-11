package by.it.tayanovskii.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str;
        TreeMap<Integer, String> map = new TreeMap<>();
        while (!(str = scanner.next()).equals("end")) {
            int id = (int) (Math.random() * 1000 + 1);
            while (map.containsKey(id)) id = (int) (Math.random() * 1000 + 1);
            map.put(id, str);
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        HashMap<String, Integer> temp = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            temp.put(entry.getValue(), entry.getKey());
        }
        HashMap<Integer, String> uniqueMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            uniqueMap.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<Integer, String> entry : uniqueMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }



}
