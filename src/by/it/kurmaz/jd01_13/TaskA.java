package by.it.kurmaz.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String,String>(null);
            else
                Integer.parseInt("Привет");
        }
        catch (NullPointerException | NumberFormatException e) {
            System.out.println("name: " + e);
            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element: elements) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.println("class: " + element.getClassName());
                    System.out.println("line: " + element.getLineNumber());
                    break;
                }
            }
        }
    }
}
