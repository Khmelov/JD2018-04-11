package by.it.shumilov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class TaskA1 {

    List<Integer> grades;


    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        task.grades = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            task.grades.add((int)(Math.random()*10) + 1);
        }


        task.clearBad(task.grades);
        System.out.println(task.grades);

    }

    private void clearBad(List<Integer> grades){
        grades.removeIf(value -> value < 4);
        /*Iterator<Integer> iterator = grades.iterator();
        while(iterator.hasNext()){
            Integer value = iterator.next();
            if (value<4)
                iterator.remove();

        }*/
    }
}
