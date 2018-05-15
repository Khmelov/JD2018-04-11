package by.it.kurmaz.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> mylist = new ListB<>();
        List<String> arList = new ArrayList<>();
        mylist.add("First");
        arList.add("First");
        mylist.add("Second");
        arList.add("Second");
        mylist.add("Third");
        arList.add("Third");
        System.out.println("Mylist: " + mylist +"\nArList: " + arList);
        mylist.add(3, "Fourth");
        arList.add(3, "Fourth");
        mylist.add(0, "Start");
        arList.add(0, "Start");
        System.out.println("Mylist: " + mylist +"\nArList: " + arList);
        mylist.remove("Start");
        arList.remove("Start");
        mylist.remove(3);
        arList.remove(3);
        System.out.println("Mylist: " + mylist +"\nArList: " + arList);
        System.out.println("Mylist: " + mylist.get(0) +"\nArList: " + arList.get(0));
        mylist.set(2, "replace");
        arList.set(2, "replace");
        System.out.println("Set Mylist: " + mylist +"\nArList: " + arList);
        List<String> addition = new ArrayList<>();
        addition.add("uno"); addition.add("duo"); addition.add("tres");
        mylist.addAll(addition);
        arList.addAll(addition);
        System.out.println("AddAll Mylist: " + mylist +"\nArList: " + arList);
    }
}
