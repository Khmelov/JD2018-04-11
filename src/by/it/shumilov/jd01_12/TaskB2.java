package by.it.shumilov.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        System.out.println(process(new ArrayList<String>(Arrays.asList("1", "2", "3","4","5", "6"))));
        LinkedList<String> ll = new LinkedList<>(Arrays.asList("1", "2", "3","4","5", "6"));
        System.out.println(process(ll));
    }



    static String process(ArrayList<String> peoples){

        int i = 1;
        while (peoples.size()>1){
            Iterator<String> it = peoples.iterator();
            while(it.hasNext()){
                it.next();
                if (i%2 == 0) {
                    it.remove();
                }
                i++;
            }
        }
        return  peoples.get(0);
    }


    static String process(LinkedList<String> peoples){
        int i = 1;
        while (peoples.size()>1){
            Iterator<String> it = peoples.iterator();
            while(it.hasNext()){
                it.next();
                if (i%2 == 0) {
                    it.remove();
                }
                i++;
            }
        }
        return  peoples.get(0);
    }
}
