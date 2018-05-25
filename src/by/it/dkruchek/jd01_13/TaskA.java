package by.it.dkruchek.jd01_13;

import java.util.HashMap;

/**
 * Created by Dmitriy.Kruchek on 5/19/2018.
 */
public class TaskA {

    public static void main(String[] args) {
        if (Math.random() > 0.5){
            try {
                new HashMap<String, String>(null);
            }
            catch (NullPointerException e){
                System.out.println("class: " + e.getClass());
                System.out.println("package: " + TaskA.class.getName());
                System.out.println("line: " + e.getStackTrace()[0].getLineNumber());
            }
        }
        else{
            try {
                Integer.parseInt("привет");
            }
            catch (NumberFormatException e){
                TaskA task = new TaskA();
                System.out.println("class: " + e.getClass());
                System.out.println("package: " + TaskA.class.getName());
                System.out.println("line: " + e.getStackTrace()[0].getLineNumber());
            }
            System.out.println(Math.sqrt(-2));

        }
    }
}
