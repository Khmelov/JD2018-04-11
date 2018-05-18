package by.it.dkruchek.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Dmitriy.Kruchek on 5/16/2018.
 */
public class TaskA1 {

    private List<Integer> grades;

    void clearBad(List<Integer> grades){
        grades.removeIf(value -> value < 4);
    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        task.grades = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int mark = random.nextInt(11);
            task.grades.add(mark);
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }
}
