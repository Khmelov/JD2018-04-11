package by.it.lanevich.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{

        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Param.class)) {
                    Param params = method.getAnnotation(Param.class);
                    System.out.println("Имя метода: "+method.getName()+ " результат= " +
                            method.invoke(beanClass.getDeclaredConstructor().newInstance(), params.a(), params.b()));
                }
            }
        }

    }


//
//        Создайте класс BeanTester который в методе main с сигнатурой, допускающей
//        Exception:public static void main(String[] args) throws Exception
//        создает экземпляр класса Bean (оператор new Bean( ) для этого использовать нельзя!),
//        а затем находит и запускает его методы, помеченные созданной аннотацией
//        с указанными в ней параметрами a и b. После каждого вызова invoke на консоль
//        выводится имя найденного метода и результат запуска.