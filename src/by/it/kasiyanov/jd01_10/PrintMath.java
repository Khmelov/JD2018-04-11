package by.it.kasiyanov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            int methodMod = method.getModifiers();
            if (Modifier.isPublic(methodMod)) {
                System.out.println(method.toString().replace("java.lang.Math.",""));
            }
        }
        Field[] fields = structMath.getDeclaredFields();
        for (Field field : fields) {
            int fieldMod = field.getModifiers();
            if (Modifier.isPublic(fieldMod)) {
                System.out.println(field.toString().replace("java.lang.Math.",""));
            }
        }
    }
}
