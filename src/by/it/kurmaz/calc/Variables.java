package by.it.kurmaz.calc;

import java.util.*;

class Variables {
    static void printHash (HashMap<String, Var> map) {
        Set<Map.Entry<String, Var>> set = map.entrySet();
        Iterator <Map.Entry<String, Var>> iter = set.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Var> entry = iter.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    static void printSort (HashMap<String, Var> map) {
        Set<String> keySet = map.keySet();
        ArrayList<String> list = new ArrayList<>(keySet);
        list.sort(Comparator.comparing(String::toString));
        for (String aList: list) {
            System.out.println("Key: " + aList + " value: " + map.get(aList));
        }
    }
}
