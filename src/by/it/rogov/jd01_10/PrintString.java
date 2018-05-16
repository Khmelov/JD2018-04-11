package by.it.rogov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stuctString = String.class;
        Method[] metods = stuctString.getDeclaredMethods();
        for (Method method : metods) {

            int methodMod = method.getModifiers();
            if (!Modifier.isStatic(methodMod)) {
                System.out.println(method.getName());
            }
        }
    }
}
