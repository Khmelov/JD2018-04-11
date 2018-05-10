package by.it.krivenkova.jd01_09;

public class Patterns {
    final static String OPERATION = "[-+*/]";
    final static String SCALAR = "-?[0-9]+\\.?[0-9]*";
    final static String VECTOR = "\\{(-?[0-9]+\\.?[0-9]*,?)+}";
    final static String MATRIX = "\\{(\\{(-?[0-9]+\\.?[0-9]*,?)+},?)+}";
}
