package by.it.zakharenko.calc;

public class Patterns {
    final static String OPERATION = "(?<=[^-/*=+{,])[-=+*/]";
    final static String LETTERS = "[A-Z]*[a-z]*[1-9]*(?==)";
    final static String BRACKETS = "\\([^()]*\\)";
    final static String SCALAR = "-?[0-9]+\\.?[0-9]*";
    final static String VECTOR = "\\{(" + SCALAR + ",?)+}";
    final static String MATRIX = "\\{(" + VECTOR + ",?)+}";
}
