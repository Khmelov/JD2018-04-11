package by.it.tayanovskii.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) throws NoSuchFieldException {

        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if(!Modifier.isStatic(method.getModifiers())) {
                String nameMethod = method.toString().trim().replaceAll("\\(.+\\)?", "");
                int index = nameMethod.lastIndexOf('.');
                nameMethod = nameMethod.substring(index+1,nameMethod.length());
                System.out.println(nameMethod);
            }

        }


    }

}
