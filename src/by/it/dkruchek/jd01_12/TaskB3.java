package by.it.dkruchek.jd01_12;

import java.util.*;

/**
 * Created by Dmitriy.Kruchek on 5/17/2018.
 */
public class TaskB3 {

    static String process(ArrayList<String> peoples){
        int index = 0;
        List<String> list = new ArrayList<>(peoples);
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (index % 2 > 0) iterator.remove();
                index++;
            }
        }
        return list.get(0);
    }

    static String process(LinkedList<String> peoples){
        int index = 0;
        LinkedList<String> list = new LinkedList<>(peoples);
        while (list.size() > 1) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (index % 2 > 0) iterator.remove();
                index++;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        // create array of 4096 strings
        String[] array = new String[4096];
        for (int i = 0; i < 4096; i++) {
            array[i] = Integer.toString(i);
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(array));

        // time arrayList method
        long startTime = System.nanoTime();
        TaskB3.process(arrayList);
        long endTime = System.nanoTime();
        System.out.println("Process with ArrayList took: " + (endTime - startTime));

        // time linkedList method
        startTime = System.nanoTime();
        TaskB3.process(linkedList);
        endTime = System.nanoTime();
        System.out.println("Process with ArrayList took: " + (endTime - startTime));
    }
}