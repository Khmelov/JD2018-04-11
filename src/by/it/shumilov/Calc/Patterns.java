package by.it.shumilov.Calc;

abstract class Patterns {
    static final String BRACKETS = "\\([^()]*\\)";
    static final String OPERATION = "(?<=[^-/*=+{,])[-=+*/]";
    static final String SCALAR = "-?[0-9]+\\.?[0-9]*";
    static final String VECTOR = "\\{(-?[0-9]+\\.?[0-9]*,?)+}";
    static final String MATRIX = "\\{(\\{(-?[0-9]+\\.?[0-9]*,?)+},?)+}";
}
