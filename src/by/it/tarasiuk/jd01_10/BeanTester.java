package by.it.tarasiuk.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> bean = Bean.class;
        Method[] methods = bean.getDeclaredMethods();
        Bean b = bean.getDeclaredConstructor().newInstance();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                double result = (Double)method.invoke(b,annotation.a(),annotation.b());
                System.out.println(method.getName()+" = "+result);
            }

        }
    }
}
