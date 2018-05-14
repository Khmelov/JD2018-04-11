package by.it.dkruchek.jd01_10;

import java.lang.annotation.*;

/**
 * Created by Dmitriy.Kruchek on 5/11/2018.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Param{

    int a();
    int b();

}

