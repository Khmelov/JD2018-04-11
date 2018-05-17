package by.it.rogov.jd01_11;

import java.util.*;


public class Runner {
    public static void main(String[] args) {
        System.out.println("Task A");
        List<String> arrayList=new ArrayList<>();
        List<String> myList=new ListA<>();
        arrayList.add("Word_1"); myList.add("Word_1");
        arrayList.add("Word_2"); myList.add("Word_2");
        arrayList.add("Word_3"); myList.add("Word_3");
        System.out.println(arrayList);
        System.out.println(myList);
        arrayList.remove(1); myList.remove(1);



//TaskB
        System.out.println("  TaskB   ");
        List<String> myListB=new ListA<>();
        arrayList.add("Word_1"); myListB.add("Word_1");
        arrayList.add("Word_2"); myListB.add("Word_2");
        arrayList.add("Word_3"); myListB.add("Word_3");
        System.out.println(arrayList);
        System.out.println(myListB);
        arrayList.remove(1); myListB.remove(1);
        arrayList.remove(3); myListB.remove(3);
        System.out.println(arrayList);
        System.out.println(myListB);
        arrayList.set(2,"Word_2");myListB.set(2,"Word_2");
        System.out.println(arrayList);
        System.out.println(myListB);
        arrayList.addAll(arrayList);myListB.addAll(myList);
        System.out.println(arrayList);
        System.out.println(myListB);
//TaskC
        System.out.println("  TaskC   ");
        Set<String> mySet=new SetC<>();
        Set<String> arraySet=new HashSet<>();
        arraySet.add("Word_5");mySet.add("Word_5");
        arraySet.add("Word_6");mySet.add("Word_6");
        arraySet.add("Word_6");mySet.add("Word_6");
        arraySet.add("Word_7");mySet.add("Word_7");
        arraySet.add("Word_4");mySet.add("Word_4");
        System.out.println(arraySet);
        System.out.println(mySet);

        arraySet.remove("Word_6");mySet.remove("Word_6");
        System.out.println(arraySet);
        System.out.println(mySet);

        List<String> listNew = new ArrayList<>();
        listNew.add("Word_5");listNew.add("Word_1");
        listNew.add("Word_2");listNew.add("Word_4");


        arraySet.addAll(listNew);mySet.addAll(listNew);
        System.out.println(arrayList);
        System.out.println(mySet);
    }
}
