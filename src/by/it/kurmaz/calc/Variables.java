package by.it.kurmaz.calc;

import java.util.*;

class Variables {
    static void printHash (HashMap<String, Var> map) {
        if (map == null) {
            System.out.println("Hashmap is empty!");
            return;
        }
        Set<Map.Entry<String, Var>> set = map.entrySet();
        for (Map.Entry<String, Var> entry: set) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

    static void printSort (HashMap<String, Var> map) {
        if (map == null) {
            System.out.println("Hashmap is empty!");
            return;
        }
        TreeMap<String, Var> treeMap = new TreeMap<>(map);
        Set<Map.Entry<String, Var>> set = treeMap.entrySet();
        for (Map.Entry<String, Var> entry: set) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }
}
