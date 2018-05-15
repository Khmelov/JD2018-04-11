package by.it.lanevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structStr = String.class;
        final Method[] methods = structStr.getDeclaredMethods();
         for (Method method : methods){
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC)
                System.out.println(method.toString().replaceAll("java.lang.String.", ""));
        }
    }
}
