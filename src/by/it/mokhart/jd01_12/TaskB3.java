package by.it.mokhart.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskB3 {
        public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>();
        for (int i = 0; i < 4096 ; i++) {
            String name = "n" + (i+1);
            people.add(name);
        }
        LinkedList<String> people2 = new LinkedList<>(people);

        System.out.println("Array: " + process(people));
        System.out.println("LinkedList: " + process(people2));
    }

    private static String process(LinkedList<String> people2) {
        int loop = 0;
        double start = System.nanoTime();
        while (people2.size() != 1) {
            ListIterator<String> iter = people2.listIterator();
            while (iter.hasNext()) {
                loop++;
                iter.next();
                if (loop%2 == 0)
                    iter.remove();
            }
        }

        System.out.println("Time taken: " + (System.nanoTime() - start)/1000);
        return people2.iterator().next();
    }


    private static String process(ArrayList<String> people) {
        int counter = people.size();
        int loop = 0;
        double start = System.nanoTime();
        while (counter != 1){
            int removed = 0;
            Iterator iterator = people.iterator();
            while (iterator.hasNext()) {
                loop++;
                iterator.next();
                if (loop%2 == 0) {
                    iterator.remove();
                    removed++;
                }
            }
            counter -= removed;
        }
        System.out.println("Time: " + (System.nanoTime() - start)/1000);
        return people.iterator().next();
    }
}

