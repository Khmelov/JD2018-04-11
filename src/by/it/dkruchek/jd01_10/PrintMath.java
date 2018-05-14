package by.it.dkruchek.jd01_10;

import java.lang.Math;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Dmitriy.Kruchek on 5/11/2018.
 */
public class PrintMath {

    public static void main(String[] args) {
        Method[] allMethods = Math.class.getDeclaredMethods();
        for (Method method : allMethods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                System.out.println(method.toString().replace("java.lang.Math.", ""));
            }
        }
        Field[] allFields = Math.class.getDeclaredFields();
        for (Field field : allFields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)){
                System.out.println(field.toString().replace("java.lang.Math.", ""));
            }
        }
    }
}


