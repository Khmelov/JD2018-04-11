package by.it.shekh.jd01_10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) {
        Class<Bean> b = Bean.class;
        Method[] methods = b.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class))
                try {
                    Object[] paramB = {method.getAnnotation(Param.class).a(), method.getAnnotation(Param.class).b()};
                    System.out.println(method.getName() + " " + method.invoke(b.getDeclaredConstructor().newInstance(), paramB));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
        }
    }
}
