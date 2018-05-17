package by.it.kurmaz.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>();
        for (int i = 0; i < 4096 ; i++) {
            String name = "n" + (i+1);
            peoples.add(name);
        }
        LinkedList<String> peoples2 = new LinkedList<>(peoples);

        System.out.println("Array process: " + process(peoples));
        System.out.println("LinkedList process: " + process(peoples2));
    }

    private static String process(LinkedList<String> peoples2) {
        int loop = 0;
        double start = System.nanoTime();
        while (peoples2.size() != 1) {
            ListIterator<String> iter = peoples2.listIterator();
            while (iter.hasNext()) {
                loop++;
                iter.next();
                if (loop%2 == 0)
                    iter.remove();
            }
        }

        System.out.println("Time taken: " + (System.nanoTime() - start)/1000);
        return peoples2.iterator().next();
    }


    private static String process(ArrayList<String> peoples) {
        int counter = peoples.size();
        int loop = 0;
        double start = System.nanoTime();
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
            //System.out.println("People left: " + peoples.toString());
        }
        System.out.println("Time taken: " + (System.nanoTime() - start)/1000);
        return peoples.iterator().next();
    }
}

