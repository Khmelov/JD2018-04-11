package by.it.kurmaz.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        LinkedList<String> peoples2 = new LinkedList<>(peoples);

        System.out.println("Array process: " + process(peoples));
        System.out.println("LinkedList process: " + process(peoples2));
    }

    private static String process(LinkedList<String> peoples2) {
        int counter = peoples2.size();
        int loop = 0;
        while (counter != 1){
            int removed = 0;
            Iterator iterator = peoples2.iterator();
            while (iterator.hasNext()) {
                loop++;
                iterator.next();
                if (loop%2 == 0) {
                    iterator.remove();
                    removed++;
                }
            }
            counter -= removed;
            System.out.println("People left: " + peoples2.toString());
        }
        return peoples2.iterator().next();
    }


    private static String process(ArrayList<String> peoples) {
        int counter = peoples.size();
        int loop = 0;
        while (counter != 1){
            int removed = 0;
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                loop++;
                iterator.next();
                if (loop%2 == 0) {
                    iterator.remove();
                    removed++;
                }
            }
            counter -= removed;
            peoples.trimToSize();
            System.out.println("People left: " + peoples.toString());
        }
        return peoples.iterator().next();
    }
}
