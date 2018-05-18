package by.it.lanevich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {

    static String process(ArrayList<String> peoples){
        int index=1;
        while(peoples.size()>1){

            for (int i=index;i<peoples.size();i+=2)
                peoples.set(i,"DELETE");
            index=(peoples.size()+index)%2;

            peoples.removeAll(Arrays.asList("DELETE"));
        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        while (peoples.size()>1){
            peoples.addLast(peoples.removeFirst());

            peoples.removeFirst();
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a0","b1","c2","d3","e4","f5","g6","h7","i8");
        ArrayList<String> arrayList = new ArrayList<>(list);
        LinkedList<String> linkedList = new LinkedList<>(list);

        System.out.println("ArrayList: "+process(arrayList));
        System.out.println("LinkedList: "+process(linkedList));
    }


}
