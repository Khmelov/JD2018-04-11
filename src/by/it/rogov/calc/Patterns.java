package by.it.rogov.calc;

abstract class Patterns {
    final static String OPERATION = "(?<=[^+/*={,-])[-=+*/()]";
    final static String SCALAR = "-?[0-9]+\\.?[0-9]*";
    final static String VECTOR = "\\{(-?[0-9]+\\.?[0-9]*,? *?)+}";
    final static String MATRIX = "\\{(\\{(-?[0-9]+\\.?[0-9]*,?)+},?)+}";
    final static String SCOBCI = "\\(([^\\(\\)]+)\\)";
    final static String Worlds = "[A-Z]*[a-z]*[1-9]*(?==)";
}
