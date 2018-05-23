package by.it.kashayed.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TaskA1 {
    private List<Integer> list = new ArrayList<>();
    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
           int score = iterator.next();
           if (score<4){
               iterator.remove();
           }
        }

    }
    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        for (int i = 0; i < 10; i++) {
            taskA1.list.add((int)Math.ceil(Math.random()*10));
        }
        System.out.println(taskA1.list);
        taskA1.clearBad(taskA1.list);
        System.out.println(taskA1.list);
    }
}
