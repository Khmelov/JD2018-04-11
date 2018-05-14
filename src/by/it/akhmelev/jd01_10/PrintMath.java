package by.it.akhmelev.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method m : methods) {
            int methodMod = m.getModifiers();
            if (Modifier.isPublic(methodMod)) {
                System.out.println(m.toString().replace("java.lang.Math.",""));
            }
        }
    }

}
