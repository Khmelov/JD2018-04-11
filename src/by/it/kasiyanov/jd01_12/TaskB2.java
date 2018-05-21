package by.it.kasiyanov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Person_1","Person_2","Person_3","Person_4","Person_5","Person_6"));
        LinkedList<String> linkList = new LinkedList<>(Arrays.asList("Person_1","Person_2","Person_3","Person_4","Person_5"));
        System.out.println(process(list));
        System.out.println(process(linkList));
    }

    private static String process(ArrayList<String> peoples){
        int index = 1;
        while(peoples.size() > 1){
            for (int i = index; i < peoples.size(); i += 2) {
                peoples.set(i,"remove");
            }
            index = (peoples.size() + index) % 2;
            peoples.removeAll(Arrays.asList("remove"));
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples){
        while(peoples.size() > 1){
            peoples.addLast(peoples.removeFirst());
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

}
