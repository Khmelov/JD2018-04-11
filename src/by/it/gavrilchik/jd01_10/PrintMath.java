package by.it.gavrilchik.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<Math> structMath = Math.class;

        Method[] methods = structMath.getMethods();
        for (Method m : methods) {
            int modifiers = m.getModifiers();
            if ((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC) {

                System.out.println(m.toString().replace("java.lang.Math", ""));

            }

        }

    }
}

