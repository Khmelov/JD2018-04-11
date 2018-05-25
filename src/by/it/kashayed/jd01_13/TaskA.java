package by.it.kashayed.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (Exception error){
            StackTraceElement[] stackTrace = error.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                //System.out.println(element);
                if(TaskA.class.getName().equals(element.getClassName())){
                  //  System.out.println(element);
                    System.out.println(" name: "+ error.getClass().getName());
                    System.out.println("class: "+ element.getClassName());
                    System.out.println(" line: "+ element.getLineNumber());
                }
            }


        }
    }
}
