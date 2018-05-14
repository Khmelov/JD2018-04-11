package by.it.kasiyanov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method method : methods) {
            int methodMod = method.getModifiers();
            if (!Modifier.isStatic(methodMod)) {
                /*String[] methodName = method.toString().split("java.lang.String.");
                System.out.println(methodName[1]);*/
                System.out.println(method.toString());
            }
        }

    }
}
