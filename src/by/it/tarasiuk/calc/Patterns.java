package by.it.tarasiuk.calc;

abstract class Patterns {
    final static String OPERATION = "[+\\-=*/]";
    final static String SCALAR = "-?[\\d]+\\.?[\\d]*";
    final static String VECTOR = "\\{(-?[\\d]+\\.?[\\d]*,?)+}";
    final static String MATRIX = "\\{(\\{(-?[\\d]+\\.?[\\d]*,?)+},?)+}";

}
