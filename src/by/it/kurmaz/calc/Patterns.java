package by.it.kurmaz.calc;

abstract class Patterns {
    static final String SORTVAR = "sortvar";
    final static String PRINTVAR = "printvar";
    final static String OPERATION = "[+\\-*/]";
    final static String SCALAR = "-?\\d+.?\\d*";
    final static String VECTOR = "\\{(-?\\d,?\\s?)+\\}";
    final static String MATRIX = "\\{(\\{(-?\\d,?\\s?)+\\},?\\s?)+\\}";
}
