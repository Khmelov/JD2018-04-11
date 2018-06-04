package by.it.tayanovskii.calc;

abstract class Patterns {
    final static String OPERATION = "(?<=[^+/*={,-])[-=+*/]";
    final static String SCALAR = "-?[0-9]+\\.?[0-9]*";
    final static String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    final static String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";
    static final String EXPRESSION = "(\\([-+*/,{}.\\ 0-9A-z]+\\))";
}
