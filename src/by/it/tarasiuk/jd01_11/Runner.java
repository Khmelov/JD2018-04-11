package by.it.tarasiuk.jd01_11;

import java.util.ArrayList;
import java.util.List;


public class Runner {
    public static void main(String[] args) {
        List<String> myListA=new ListA<>();
        List<String> arList=new ArrayList<>();

        myListA.add("A"); arList.add("A");
        myListA.add("B"); arList.add("B");
        myListA.add("C"); arList.add("C");
        System.out.println("add\nmyListA:"+myListA+"\narList:"+arList+"\n");

        myListA.add(2,"D"); arList.add(2,"D");
        myListA.add(0,"V"); arList.add(0,"V");
        System.out.println("add()\nmyListA:"+myListA+"\narList:"+arList+"\n");

        myListA.remove("V"); arList.remove("V");
        myListA.remove(3); arList.remove(3);
        System.out.println("remove \nmyListA:"+myListA+"\narList"+arList+"\n");

        System.out.println("get \nmyListA(0):"+myListA.get(0)+"\narList(0):"+arList.get(0)+"\n");

        List<String> myListB=new ListB<>();
        myListB.add("A"); myListB.add("B"); myListB.add("C");
        System.out.println("set \nmyListB(2) \"Z\":"+myListB.set(2,"Z")+"\narList(2) \"Z\":"+arList.set(2,"Z")+"\n");



//        Set<String> hsSet=new HashSet<>();todo SetC realization
//        Set<String> mySet=new SetC<>();

    }
}
