package by.it.lanevich.jd01_10;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface Param {
    int a();
    int b();

}
