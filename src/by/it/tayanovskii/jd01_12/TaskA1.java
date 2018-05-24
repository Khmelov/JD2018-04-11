package by.it.tayanovskii.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {

    private List<Integer> grades;

    void clearBad(List<Integer> grades) {
        grades.removeIf(value -> value < 4);

    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        task.grades = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            task.grades.add(1+(int)(Math.random()*10));
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }
}
