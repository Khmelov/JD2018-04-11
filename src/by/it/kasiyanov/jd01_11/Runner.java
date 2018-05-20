package by.it.kasiyanov.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        //TaskA
        List<String> myList=new ListA<>();
        List<String> arrayList=new ArrayList<>();
        arrayList.add("Word_1"); myList.add("Word_1");
        arrayList.add("Word_2"); myList.add("Word_2");
        arrayList.add("Word_3"); myList.add("Word_3");
        arrayList.add("Word_4"); myList.add("Word_4");
        arrayList.add("Word_5"); myList.add("Word_5");
        System.out.println(arrayList);
        System.out.println(myList);
        arrayList.remove(1); myList.remove(1);
        arrayList.remove(3); myList.remove(3);
        System.out.println(arrayList);
        System.out.println(myList);


        //TaskC
        Set<String> mySet=new SetC<>();
        Set<String> arraySet=new HashSet<>();
        System.out.println("\n" + "SetC" + "\n");
        arraySet.add("Word_1"); mySet.add("Word_1");
        arraySet.add("Word_2"); mySet.add("Word_2");
        arraySet.add("Word_3"); mySet.add("Word_3");
        arraySet.add("Word_4"); mySet.add("Word_4");
        arraySet.add("Word_5"); mySet.add("Word_5");
        System.out.println(arraySet);
        System.out.println(mySet);
        arraySet.remove("Word_2"); mySet.remove("Word_2");
        arraySet.remove("Word_4"); mySet.remove("Word_4");
        System.out.println(arraySet);
        System.out.println(mySet);
    }
}
