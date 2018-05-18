package by.it.dkruchek.calc;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
abstract class Patterns {
    final static String OPERATION = "[-=+/\\*]";
    final static String SCALAR = "-?[0-9]+\\.?[0-9]*";
    final static String VECTOR = "\\{(" +  SCALAR + ",?)+}";
    final static String MATRIX = "\\{(" + VECTOR + ",?)+}";
}
