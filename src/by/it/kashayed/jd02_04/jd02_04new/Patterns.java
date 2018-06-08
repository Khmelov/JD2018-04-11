package by.it.kashayed.jd02_04.jd02_04new;

public class Patterns {
     static final String OPERATION="(?<=[^+/*={,-])[-=+*/]";
     static final String SCALAR ="-?[0-9]+\\.?[0-9]*";
     static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+\\}";
     static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+\\},?)+\\}";
}
