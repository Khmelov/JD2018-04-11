package by.it.kurmaz.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<String> mySet = new SetC<>();
        Set<String> hashSet = new HashSet<>();

        mySet.add("First"); mySet.add("Second"); mySet.add("Third");
        hashSet.add("First"); hashSet.add("Second"); hashSet.add("Third");
        System.out.println("Add Myset: " + mySet + "\nHashSet: " + hashSet);

        mySet.remove("Second");
        hashSet.remove("Second");
        System.out.println("Remove Myset: " + mySet + "\nHashSet: " + hashSet+ "\nSize: " + mySet.size() + " hashset size: " + hashSet.size());

        List<String> addSet = new ArrayList<>(); addSet.add("Fourth"); addSet.add("Fifth"); addSet.add("First"); addSet.add(null); addSet.add(null);
        mySet.addAll(addSet);
        hashSet.addAll(addSet);
        System.out.println("AddAll Myset: " + mySet + "\nHashSet: " + hashSet + "\nSize: " + mySet.size());

        System.out.println(mySet.containsAll(addSet));

        mySet.removeAll(addSet);
        hashSet.removeAll(addSet);
        System.out.println("Remove Myset: " + mySet + "\nHashSet: " + hashSet + "\nSize: " + mySet.size() + " hashset size: " + hashSet.size());


    }
}
