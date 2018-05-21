package by.it.kurmaz.jd01_12;

import java.util.ArrayList;

import java.util.List;

public class TaskA1 {

    private static List <Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            grades.add((int) (Math.random()*10));
        }
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearBad(grades);
    }

    private void clearBad(List<Integer> grades) {
        grades.removeIf(o -> !(o > 3));
        System.out.println("New grades: " + grades);
    }
}
