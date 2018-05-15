package by.it.obmetko.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Runner {
    public static void main(String[] args) {
        List<String> arrayList=new ArrayList<>();
        List<String> myList=new ListA<>();
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
        Set<String> mySet = new SetC<>();
        mySet.add("one");
        mySet.add("two");
        System.out.println(mySet);

        ArrayList<String> myArrList = new ArrayList<>();
        myArrList.add(null);
        myArrList.add("one");
        myArrList.add("two");
        System.out.println(myArrList.size());
        Set<Short> a = new SetC<>();
        Set<Short> b = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            b.add((short) (i * 2));
            a.add((short) (i * 2));
        }
        System.out.println("b " + b.toString());
        System.out.println("a " + a.toString());
    }
}
