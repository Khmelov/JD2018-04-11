package by.it.kurmaz.jd01_09;

abstract class Patterns {
    final static String OPERATION = "[+\\-*/]";
    final static String SCALAR = "-?\\d+.?\\d*";
    final static String VECTOR = "\\{(-?\\d,?\\s?)+\\}";
    final static String MATRIX = "\\{(\\{(-?\\d,?\\s?)+\\},?\\s?)+\\}";
}
