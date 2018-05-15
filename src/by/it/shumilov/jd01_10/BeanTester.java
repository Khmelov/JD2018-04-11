package by.it.shumilov.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;

        Method[] methods = beanClass.getDeclaredMethods();

        for (Method method : methods)
            if (method.isAnnotationPresent(Param.class)) {
                System.out.println(method.getName());
                Param param = method.getDeclaredAnnotation(Param.class);
                if (method.toString().lastIndexOf("static") > 0) {
                    System.out.println(method.invoke(null, param.a(), param.b()));
                } else {

                    //method.invoke(beanClass,param.a(),param.b());
                    Object bean = beanClass.newInstance();
                    System.out.println(method.invoke(bean, param.a(), param.b()));
                }
            }
    }
}
