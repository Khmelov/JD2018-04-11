package by.it.tarasiuk.jd01_12;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        List<String> peoples = Arrays.asList("p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9");
        ArrayList<String> arrayList = new ArrayList<>(peoples);
        LinkedList<String> linkedList = new LinkedList<>(peoples);
        System.out.println("ArrayList name: " + process(arrayList) +
                "\nLinkedList name: " + process(linkedList));
    }

    private static String process(ArrayList<String> peoples) {
        int lost = 0;
        int k = 2;
        while (peoples.size() > 1) {
            lost = (lost + k - 1) % peoples.size();
            peoples.remove(lost);
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

}
