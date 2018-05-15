package by.it.shumilov.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<String> arrayList = new HashSet<>();

        SetC<String> myList = new SetC<>();
        arrayList.add("Word_1");myList.add("Word_1");
        arrayList.add("Word_2");myList.add("Word_2");
        arrayList.add("Word_3");myList.add("Word_3");
        arrayList.add("Word_4");myList.add("Word_4");
        arrayList.add("Word_5");



        myList.add("Word_1");
        myList.add("Word_2");
        myList.add("Word_3");
        myList.add("Word_4");
        myList.add("Word_4");


        System.out.println(arrayList);
        System.out.println(myList);


        String elements[] = { "A", "B", "C", "D", "E" };
        Set<String> set = new SetC<String>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");

        elements = new String[] { "E", "F" };

        System.out.println(set.addAll(Arrays.asList(elements)));

        System.out.println(set);

        Set<Short> a = new HashSet<>();
        Set<Short> e = new SetC<>();
        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);
        a.addAll(added);
        e.addAll(added);
        System.out.println(a);
        System.out.println(e);
    }
}
