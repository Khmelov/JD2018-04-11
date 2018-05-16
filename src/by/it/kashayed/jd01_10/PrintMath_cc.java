package by.it.kashayed.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class PrintMath_cc {
    static void method (Class<?> cls){
        Class<Math> clss = Math.class;
        Method[] methods = clss.getMethods();
        for (Method met : methods) {
            if ((met.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                String res = met.toString().replaceAll("java.lang.Math.", "");
                System.out.println(res);
            }
        }
        Field[] fields = clss.getFields();
        for (Field field : fields) {
            String res = field.toString().replaceAll("java.lang.Math.", "");
            System.out.println(res);
        }


    }

    public static void main(String[] args) {
        method(Math.class);

    }
}
