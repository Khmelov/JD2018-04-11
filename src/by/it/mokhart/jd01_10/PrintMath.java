package by.it.mokhart.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) throws NoSuchFieldException {
        /*Math.class.var*/
        Class<Math> mathStructure = Math.class;
      //  mathStructure.getDeclaredField("E");//alt+enter (1)
        Method[] methods = mathStructure.getDeclaredMethods();
        for (Method method : methods) {
            int methodsMod = method.getModifiers();
            if ((methodsMod & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.println(method);
            }
        }
    }
}
