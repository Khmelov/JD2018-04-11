package by.it.dkruchek.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Dmitriy.Kruchek on 5/11/2018.
 */
public class PrintString {

    public static void main(String[] args) {
        Method[] allMethods = String.class.getDeclaredMethods();
        for (Method method : allMethods) {
            int modifiers = method.getModifiers();
            if (! Modifier.isStatic(modifiers)){
                System.out.println(method.getName());
            }
        }
    }
}
