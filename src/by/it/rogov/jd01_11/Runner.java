package by.it.rogov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> arrayList=new ArrayList<>();
        List<String> myList=new ListB<>();
        arrayList.add("Word_1"); myList.add("Word_1");
        arrayList.add("Word_2"); myList.add("Word_2");
        arrayList.add("Word_3"); myList.add("Word_3");
        arrayList.add("Word_4"); myList.add("Word_4");
        arrayList.add("Word_5"); myList.add("Word_5");
        arrayList.add("Word_6"); myList.add("Word_6");
        System.out.println(arrayList);
        System.out.println(myList);
        arrayList.remove(1); myList.remove(1);
        arrayList.remove(3); myList.remove(3);
        System.out.println(arrayList);
        System.out.println(myList);
        arrayList.set(2,"Word_2");myList.set(2,"Word_2");
        System.out.println(arrayList);
        System.out.println(myList);
        arrayList.addAll(arrayList);myList.addAll(myList);
        System.out.println(arrayList);
        System.out.println(myList);
    }
}
