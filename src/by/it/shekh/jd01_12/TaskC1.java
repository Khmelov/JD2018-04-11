package by.it.shekh.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        HashMap<Integer, String> map = new HashMap<>();
        while (!(str = sc.nextLine()).equals("end")) {
            int id;
            id = (int) (Math.random() * 5000 + 1);
            while (!map.containsKey(id))
                map.put(id, str);
        }
        printMap(map);
        printSortMap(map);


        HashMap<String, Integer> temp = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            temp.put(entry.getValue(), entry.getKey());
        }
        printMap(temp);
        HashMap<Integer, String> uniqueMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            uniqueMap.put(entry.getValue(), entry.getKey());
        }
        printMap(uniqueMap);
        printSortMap(uniqueMap);
    }


    private static void printMap(HashMap<?, ?> map) {
        System.out.println();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static void printSortMap(HashMap<Integer, String> map) {
        SortedSet<Integer> sortedKeys = new TreeSet<>(map.keySet());
        System.out.println();
        for (Integer key : sortedKeys) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }

    }

}
