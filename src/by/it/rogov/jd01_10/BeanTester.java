package by.it.rogov.jd01_10;

import java.lang.reflect.Method;


public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class bean = Bean.class;
        Method[] methodsBean = bean.getDeclaredMethods();
        Object obj = bean.getDeclaredConstructor().newInstance();

        for (Method method : methodsBean) {
            if (method.isAnnotationPresent(Param.class)) {
                Param p = method.getAnnotation(Param.class);
                Object d = method.invoke(obj, p.a(), p.b());
                System.out.println(method.getName() + " " + d);


            }
        }

    }
}
