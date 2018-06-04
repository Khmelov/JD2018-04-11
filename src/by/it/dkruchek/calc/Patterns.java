package by.it.dkruchek.calc;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
abstract class Patterns {
    static final String OPERATION = "(?<=[^-+/*{=,])([-=+/*])";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{(" +  SCALAR + ",?\\s?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    static final String PARENTHESES_EXPRESSION = "\\(([^\\(\\)]+)\\)";
}
