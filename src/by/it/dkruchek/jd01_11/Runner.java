package by.it.dkruchek.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dmitriy.Kruchek on 5/14/2018.
 */
public class Runner {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> myList = new ListA<>();
        arrayList.add("First"); myList.add("First");
        arrayList.add("Second"); myList.add("Second");
        arrayList.add("Third"); myList.add("Third");
        arrayList.add("Forth"); myList.add("Forth");
        arrayList.add("Fifth"); myList.add("Fifth");
        System.out.println(arrayList);
        System.out.println(myList);
        arrayList.remove(1); myList.remove(1);
        arrayList.remove(2); myList.remove(2);
        System.out.println(arrayList);
        System.out.println(myList);
        arrayList.add("Second"); myList.add("Second");
        arrayList.add("Third"); myList.add("Third");
        System.out.println(arrayList);
        System.out.println(myList);
        Set<String> hashSet = new HashSet<>();
        Set<String> mySet = new SetC<>();
        mySet.add("First"); hashSet.add("First");
        mySet.add("Second"); hashSet.add("Second");
        mySet.add("Third");  hashSet.add("Third");
        System.out.println(hashSet);
        System.out.println(mySet);


    }
}
