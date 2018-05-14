package by.it.kurmaz.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> bean = Bean.class;
        Method[] methods = bean.getDeclaredMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                Bean aBean = bean.newInstance();
                double result = (Double)method.invoke(aBean, param.a(), param.b());
                System.out.println(method.getName() + " " + result);
            }
        }

    }
}
