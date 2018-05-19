package by.it.mokhart.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<String> stringStructure = String.class;
        stringStructure.getDeclaredMethods();
        Method[] methods = stringStructure.getDeclaredMethods();
        for (Method method : methods) {
            if (!(Modifier.isStatic(method.getModifiers()))) {
                String out = method.toString().replaceAll("java.lang.String.", "");
                System.out.println(out);
            }
        }

    }
}
