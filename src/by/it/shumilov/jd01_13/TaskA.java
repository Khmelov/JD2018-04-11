package by.it.shumilov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try{
        if (Math.random()>0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
        }
        catch (NumberFormatException | NullPointerException e) {

            StackTraceElement[] stackTrace = e.getStackTrace();
            Class<TaskA> clazz = TaskA.class;  //out class
            for (int i = 0; i < stackTrace.length; i++) {
                if (clazz.getName().equals(stackTrace[i].getClassName())) {
                    System.out.printf(" name: %s\nclass: %s\n line: %s\n", e.getClass().getName(), stackTrace[i].getClassName(), stackTrace[i].getLineNumber());
                    break;
                }
            }
        }
    }

    static void printEx(Exception e){
        System.out.println(e.getClass().getName());
    }
}
