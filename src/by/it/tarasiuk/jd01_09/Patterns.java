package by.it.tarasiuk.jd01_09;

abstract class Patterns {
    final static String OPERATION = "[+\\-*/]";
    final static String SCALAR = "-?[\\d]+\\.?[\\d]*";
    final static String VECTOR = "\\{(-?[\\d]+\\.?[\\d]*,?)+}";
    final static String MATRIX = "\\{(\\{(-?[\\d]+\\.?[\\d]*,?)+},?)+}";

}
