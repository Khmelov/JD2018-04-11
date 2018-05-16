package by.it.tayanovskii.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        Class<Bean> beanClass = Bean.class;
        Method[] methodsBean = beanClass.getDeclaredMethods();
        for (Method method : methodsBean) {
            if(method.isAnnotationPresent(Param.class))
            {
                Param annotation = method.getAnnotation(Param.class);
                    Object object = beanClass.newInstance();
                    System.out.println( method.getName() + " " + method.invoke(object, annotation.a(), annotation.b()));


            }
        }

    }
}
