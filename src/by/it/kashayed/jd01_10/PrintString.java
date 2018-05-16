package by.it.kashayed.jd01_10;

import javax.naming.Name;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> cls =String.class;
        Method[] names = cls.getDeclaredMethods();
        for (Method method : names) {
            if (!Modifier.isStatic(method.getModifiers()))
            System.out.println(method.getName());
        }

    }
}