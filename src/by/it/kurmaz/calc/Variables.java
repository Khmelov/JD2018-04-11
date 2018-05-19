package by.it.kurmaz.calc;

import java.util.*;

class Variables {
    static void printHash (HashMap<String, Var> map) {
        Set<Map.Entry<String, Var>> set = map.entrySet();
        for (Map.Entry<String, Var> entry: set) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static void printSort (HashMap<String, Var> map) {
        TreeMap<String, Var> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);
    }
}
