package by.it.kashayed.jd01_12;

import java.util.*;

public class TaskB2 {
    static String process(ArrayList<String> peoples){
        ArrayList<String> a = new ArrayList<>(peoples);
        for (int i = 0; i < a.size()-1; i++) {
            a.remove(i+1);
            a.add(a.get(i));
        }
        while(a.size()!=1){
            a.remove(0);
        }
        System.out.println(a);
        return a.get(0);
    }


    static String process(LinkedList<String> peoples){
        ArrayList<String> a = new ArrayList<>(peoples);
        for (int i = 0; i < a.size()-1; i++) {
            a.remove(i+1);
            a.add(a.get(i));
        }
        while(a.size()!=1){
            a.remove(0);
        }
        System.out.println(a);
        return a.get(0);
    }

    public static void main(String[] args) {        ArrayList<String> list = new ArrayList<String>();
        Scanner scaner =new Scanner(System.in);
        int n=scaner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(i, "people"+(i+1));
        }
        System.out.println(list);
       LinkedList<String> lilist = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lilist.add(i, "people"+(i+1));
        }
        System.out.println(lilist);
        process(list);
        process(lilist);

    }

}
