package by.it.zakharenko.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {  //из массива
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {  //из такой же переменной
        this.value = otherMatrix.value;
    }

    Matrix(String strMatrix) {  //из строки
        String[] strValues = strMatrix
                .replaceAll("\\{\\{|\\}\\}", "")
                .trim()
                .split("\\},\\s?\\{");
        String[] strValues1 = strValues[0]
                .trim()
                .split(",\\s*");
        value = new double[strValues.length][strValues1.length];
        for (int i = 0; i < strValues.length; i++) {
            String[] mas = strValues[i]
                    .trim()
                    .split(",\\s?");
            for (int j = 0; j < strValues1.length; j++) {
                value[i][j] = Double.parseDouble(mas[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double scalar = ((Scalar) other).getValue();
            for (double[] element : matrix)
                for (int i = 0; i < matrix.length; i++) {
                    element[i] += scalar;
                }
            return new Matrix(matrix);
        } else if (other instanceof Matrix) {
            double[][] matrix = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(matrix);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double scalar = ((Scalar) other).getValue();
            for (double[] element : matrix)
                for (int i = 0; i < matrix.length; i++) {
                    element[i] -= scalar;
                }
            return new Matrix(matrix);
        } else if (other instanceof Matrix) {
            double[][] matrix = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(matrix);
        } else
            return super.sub(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double scalar = ((Scalar) other).getValue();
            for (double[] element : matrix)
                for (int i = 0; i < matrix.length; i++) {
                    element[i] /= scalar;
                }
            return new Matrix(matrix);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                if ((value[i].length - 1) > j)
                    delimiter = ", ";
                else delimiter = "}, {";

            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public double[][] getValue() {
        return value;
    }

}


