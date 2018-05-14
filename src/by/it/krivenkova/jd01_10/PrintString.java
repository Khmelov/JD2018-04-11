package by.it.krivenkova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method m : methods){
            if (!Modifier.isStatic(m.getModifiers())){
                String res = m.toString();
                res = m.getName();
                System.out.println(res);
            }
        }
    }
}
