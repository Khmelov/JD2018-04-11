package by.it.kurmaz.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> math = Math.class;
        Field[] fields = math.getFields();
        for (Field field: fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
            {
                String f = field.toString();
                f = f.replace("java.lang.Math.", "");
                System.out.println(f);
            }
        }
        Method[] methods = math.getDeclaredMethods();
        for (Method m: methods) {
            if ((m.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                String method = m.toString();
                method = method.replace("java.lang.Math.", "");
                System.out.println(method);
            }
        }

    }

}
