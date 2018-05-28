package by.it.mokhart.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        LinkedList<String> people2 = new LinkedList<>(people);

        System.out.println("Array: " + process(people));
        System.out.println("LinkedList: " + process(people2));
    }

    private static String process(LinkedList<String> people2) {
        int counter = people2.size();
        int loop = 0;
        while (counter != 1){
            int removed = 0;
            Iterator iterator = people2.iterator();
            while (iterator.hasNext()) {
                loop++;
                iterator.next();
                if (loop%2 == 0) {
                    iterator.remove();
                    removed++;
                }
            }
            counter -= removed;
            System.out.println("Осталось людей: " + people2.toString());
        }
        return people2.iterator().next();
    }


    private static String process(ArrayList<String> people) {
        int counter = people.size();
        int loop = 0;
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
            people.trimToSize();
            System.out.println("Осталось людей: " + people.toString());
        }
        return people.iterator().next();
    }
}
