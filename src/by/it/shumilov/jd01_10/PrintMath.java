package by.it.shumilov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();

        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(method.toString().replace("java.lang.Math.",""));
        }

        Field[] fields = structMath.getFields();
        for (Field field : fields) {
            System.out.println(field.toString().replace("java.lang.Math.",""));
        }


    }
}
