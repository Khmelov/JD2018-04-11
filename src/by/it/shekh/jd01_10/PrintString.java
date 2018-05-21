package by.it.shekh.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method m : methods) {
            if (!Modifier.isStatic(m.getModifiers()))
            System.out.println(m.getName());
        }
    }
}
