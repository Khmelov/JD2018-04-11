package by.it.kurmaz.calc;

import java.util.*;

class Variables {

    static HashMap<String, Var> hashMap = new HashMap<>();

    static void recover() throws CalcException {
        hashMap = Saver.recover();
    }

    static void save () {
        Saver.save(hashMap);
    }

    static void printHash () {
        if ((hashMap == null) || (hashMap.size() == 0)) {
            System.out.println(ConsoleRunner.resMan.getString("msg.emptyHashmap"));
            return;
        }
        Set<Map.Entry<String, Var>> set = hashMap.entrySet();
        for (Map.Entry<String, Var> entry: set) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }

    static void printSort () {
        if (hashMap == null) {
            System.out.println(ConsoleRunner.resMan.getString("msg.emptyHashmap"));
            return;
        }
        TreeMap<String, Var> treeMap = new TreeMap<>(hashMap);
        Set<Map.Entry<String, Var>> set = treeMap.entrySet();
        for (Map.Entry<String, Var> entry: set) {
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
    }
}
