package by.it.shumilov.jd01_10;

import java.lang.reflect.Method;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;

        Method[] methods = stringClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.toString().lastIndexOf("static") < 0)
                System.out.println(method.getName());
        }


    }
}
