package by.it.zakharenko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            String name = e.getClass().getName();
            int line = -1;
            StackTraceElement[] stackTrace = e.getStackTrace();
            Class<TaskA> clazz=TaskA.class; //наш текущий класс
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement element=stackTrace[i];
                if (clazz.getName().equals(element.getClassName()))
                {
                    String strClass=element.getClassName();
                    System.out.printf(" name: %s\nclass: %s\n line: %d\n", name, strClass, element.getLineNumber());
                    break;
                }
            }

        }
    }
}
