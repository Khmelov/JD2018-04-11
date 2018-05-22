package by.it.shumilov.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            list.add("4096");
        }
        System.out.println(process(new ArrayList<>(list)));

        System.out.println(process(new LinkedList<>(list)));
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
