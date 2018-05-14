package by.it.krivenkova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) throws NoSuchFieldException{
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method m : methods){
            int modifiers = m.getModifiers();
            if (Modifier.isPublic(modifiers)){
                //if ((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC){
               String res = m.toString().replaceAll("java.lang.Math.","");
                System.out.println(res);
            }
        }
        Field[] fields = structMath.getFields();
        for (Field field : fields){
            String res = field.toString().replaceAll("java.lang.Math.","");
            System.out.println(res);
        }
    }
}
