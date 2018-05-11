package by.it.mokhart.jd01_09;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return getValue();
    }

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] strValues = strMatrix
                .replaceAll("\\{\\{|\\}\\}", "")
                .trim()
                .split("\\},\\s?\\{");//?
        String[] strValues1 = strValues[0]
                .trim()
                .split(",\\s?");
        value = new double[strValues.length][strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            String[] matrix = strValues[i]
                    .trim()
                    .split(",\\s?");
            for (int j = 0; j < strValues.length; j++) {
                value[i][j] = Double.parseDouble(matrix[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix) {
            double[][] add = Arrays.copyOf(value, value.length);
            for (int i = 0; i < this.value.length; i++) {
                add[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < add.length; i++) {
                for (int j = 0; j < add.length; j++) {
                    add[i][j] = add[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(add);
        } else if (other instanceof Scalar) {
            double[][] add = Arrays.copyOf(value, value.length);
            for (int i = 0; i < add.length; i++) {
                for (int j = 0; j < add.length; j++) {
                    add[i][j] = add[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(add);
        } else return null;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix) {
            double[][] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < this.value.length; i++) {
                sub[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub.length; j++) {
                    sub[i][j] = sub[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);
        } else if (other instanceof Scalar) {
            double[][] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub.length; j++) {
                    sub[i][j] = sub[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);
        } else return null;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            double[][] mul = Arrays.copyOf(value, value.length);
          //  double[][] sum =new sum[][](new double[][]{0},{0});
            for (int i = 0; i < value.length; i++) {
                mul[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    mul[i][j] = mul[i][j] * ((Matrix) other).value[i][j];
                 //   sum [i][j] +=  mul[i][j];
                }
            }
            return new Matrix(mul);
        } else if (other instanceof Scalar) {
            double[][] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul.length; j++) {
                    mul[i][j] = mul[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);
        } else return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        String delimetr = "{";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                builder.append(delimetr).append(value[i][j]);
                delimetr = ", ";
            }
            delimetr = ", {";
            builder.append("}");
        }
        builder.append("}");
        return builder.toString();
    }
}
