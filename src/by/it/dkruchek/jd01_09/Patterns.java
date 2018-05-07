package by.it.dkruchek.jd01_09;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
abstract class Patterns {
    final static String OPERATION = "[-+/\\*]";
    final static String SCALAR = "-?[0-9]+\\.?[0-9]*";
    final static String VECTOR = "\\{(" +  SCALAR + ",?)+}";
    final static String MATRIX = "\\{(" + VECTOR + ",?)+}";
}
