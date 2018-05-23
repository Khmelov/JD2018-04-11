package by.it.shekh.jd01_12;

import java.util.*;

public class TaskB2 {
    static String process(ArrayList<String> peoples) {
        boolean deleted = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (deleted) {
                    iterator.remove();
                }
                deleted = !deleted;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        boolean deleted = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (deleted) {
                    iterator.remove();
                }
                deleted = !deleted;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("w1", "w2", "w3", "w4", "w5", "w6", "w7", "w7", "w8", "w9");
        ArrayList<String> arrayList = new ArrayList<>(list);
        System.out.println(process(arrayList));
        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.println(process(linkedList));
    }
}
