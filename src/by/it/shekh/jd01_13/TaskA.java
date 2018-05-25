package by.it.shekh.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {
            String name = e.getClass().getName();
            String strClasz=e.getClass().getName();
            int line=0;
            StackTraceElement[] stackTrace = e.getStackTrace();
            Class<TaskA> clasz=TaskA.class;
            for (int i = 0; i < stackTrace.length; i++) {

                StackTraceElement element=stackTrace[i];
                if (clasz.getName().equals(element.getClassName())){
                    strClasz=element.getClassName();
                    line=element.getLineNumber();
                }

            }
            System.out.printf(" name: %s\n" + "class: %s\n" + " line: %d", name,strClasz,line);

        }


    }
}
