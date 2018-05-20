package by.it.tarasiuk.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {
    public static void main(String[] args) {
        List<String> peoples = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            peoples.add("People №" + Integer.toString(i));
        }
        ArrayList<String> arrayList = new ArrayList<>(peoples);
        LinkedList<String> linkedList = new LinkedList<>(peoples);
        Long timerA = System.nanoTime();
        System.out.println("ArrayList name: " + process(arrayList) + "\nWorking time, ms=" + ((System.nanoTime() - timerA) / 1e6));
        Long timerL = System.nanoTime();
        System.out.println("LinkedList name: " + process(linkedList) + "\nWorking time, ms=" + ((System.nanoTime() - timerL) / 1e6));
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
