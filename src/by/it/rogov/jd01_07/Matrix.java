package by.it.rogov.jd01_07;

import java.util.Arrays;

class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] array = strMatrix.split("}.");
        int u = array[0].split(",").length;

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].replace('{', ' ')
                    .replace('}', ' ')
                    .trim();
        }
        value = new double[array.length][u];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < u; j++) {
                String g = array[i].split(",")[j];
                value[i][j] = Double.parseDouble(array[i].split(",")[j]);

            }

        }

    }


    @Override
    public String toString() {
        String[] array = new String[value.length];
        for (int i = 0; i < value.length; i++) {
            array[i] = Arrays.toString(value[i]);

        }
        return Arrays.toString(array)
                .replace('[', '{')
                .replace(']', '}');
    }


}
