package by.it.akhmelev.jd01_07;

import java.util.Arrays;

public class Matrix extends AbstractVar {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Just some Matrix";
    }
}
