package by.it.kurmaz.calc;

abstract class Patterns {
    final static String BRACKETS = "\\(([\\w+/*\\-\\+\\s\\.{},]+)\\)";
    static final String SORTVAR = "sortvar";
    final static String PRINTVAR = "printvar";
    final static String OPERATION = "(?<=[^+/*={,\\-\\s?]\\s?)[-=+*/]";
    final static String SCALAR = "-?\\s?\\d+\\.?\\d*";
    final static String VECTOR = "\\{(-?\\d,?.?\\s?)+\\}";
    final static String MATRIX = "\\{(\\{(-?\\d,?.?\\s?)+\\},?\\s?)+\\}";
}