package by.it.mokhart.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {

    private static List <Integer> marks = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            marks.add((int) (Math.random()*10));
        }
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearBad(marks);
    }

    private void clearBad(List<Integer> marks) {
        marks.removeIf(o -> !(o > 3));
        System.out.println("New grades: " + marks);
    }
}
