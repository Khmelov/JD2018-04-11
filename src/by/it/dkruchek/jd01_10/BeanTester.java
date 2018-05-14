package by.it.dkruchek.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Dmitriy.Kruchek on 5/12/2018.
 */
public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> cls = Bean.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)){
                Object result;
                Object beanInstance = null;
                Param param = method.getAnnotation(Param.class);
                int modifiers = method.getModifiers();
                if (Modifier.isStatic(modifiers))
                {
                    result = method.invoke(beanInstance, param.a(), param.b());
                }
                else{
                    if (beanInstance == null){
                        beanInstance = cls.getDeclaredConstructor().newInstance();

                    }
                    result = method.invoke(beanInstance, param.a(), param.b());
                }
                System.out.println(method.getName());
                System.out.println(result);
                System.out.println("--------------");
            }
        }
    }
}
