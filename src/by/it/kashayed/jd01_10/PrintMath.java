package by.it.kashayed.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> cls = Math.class;
        Method[] method = cls.getMethods();
        Field[] fields = cls.getFields();
//        for (Method met : method) {
//            System.out.println(met);
//        }
        for (Method met : method) {
            if ((met.getModifiers()&Modifier.PUBLIC)==Modifier.PUBLIC){
                System.out.println(met.toString().replace("java.lang.Math.",""));
            }
        }
//        for (Field fil : fields) {
//            if((fil.getModifiers()&Modifier.PUBLIC)==Modifier.PUBLIC)
//                System.out.println(fil.toString().replace("java.lang.Math.",""));
//        }
        for (Field fil : fields) {
            if(Modifier.isPublic(fil.getModifiers()))
                System.out.println(fil.toString().replace("java.lang.Math.",""));
        }

    }
}
