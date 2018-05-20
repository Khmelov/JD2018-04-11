package by.it.krivenkova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> grades;

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value < 4)
                iterator.remove();
        }

    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        task.grades = new ArrayList<>();
        for (int i = 0; i < 25; i++)
            task.grades.add(1 + (int) (Math.random() * 10));
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }


}
