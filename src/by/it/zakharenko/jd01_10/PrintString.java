package by.it.zakharenko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;//String.class.var
        Method[] methods = structString.getDeclaredMethods();
        for (Method m : methods) {
            if (!Modifier.isStatic(m.getModifiers())) {
                String result = m.toString();
                result = m.getName();
                System.out.println(result);
            }
        }
    }
}
