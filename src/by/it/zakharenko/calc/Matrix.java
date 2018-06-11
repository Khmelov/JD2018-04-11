package by.it.zakharenko.calc;

import java.util.Arrays;

import static by.it.zakharenko.calc.ConsoleRunner.rm;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {  //из массива
        this.value = value;
    }

    public Matrix(Matrix otherMatrix) {  //из такой же переменной
        this.value = otherMatrix.value;
    }

    public Matrix(String strMatrix) {  //из строки
        String[] strValues = strMatrix
                .replaceAll("\\{\\{|\\}\\}", "")
                .trim()
                .split("\\},\\s?\\{");
        String[] strValues1 = strValues[0]
                .trim()
                .split(",\\s?");
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
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
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
            double[][] matrix = new double[this.value.length][this.value[0].length];
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException(rm.getString(Message.MATRICADIFFERENTSIZES) + this + "+" + other);
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
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
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
            double[][] matrix = new double[this.value.length][this.value[0].length];
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException(rm.getString(Message.MATRICADIFFERENTSIZES) + this + "-" + other);
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
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double matrix[][] = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++)
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[i].length; i1++) {
                    matrix[i][i1] *= scalar;
                }
            }
            return new Matrix(matrix);
        } else if (other instanceof Vector) {
            double result[] = new double[((Vector) other).getValue().length];
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < result.length; j++)
                    result[i] += (this.value[i][j] * ((Vector) other).getValue()[j]);
            return new Vector(result);
        } else if (other instanceof Matrix) {
            double matrix[][] = new double[this.value.length][((Matrix) other).value[0].length];
            if ((this.value.length != ((Matrix) other).value.length) || (this.value[0].length != ((Matrix) other).value[0].length))
                throw new CalcException(rm.getString(Message.MATRICADIFFERENTSIZES) + this + "*" + other);
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++)
                    for (int k = 0; k < matrix[i].length; k++)
                        matrix[i][j] += (this.value[i][k] * ((Matrix) other).value[k][j]);

            return new Matrix(matrix);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            double scalar = ((Scalar) other).getValue();
            if (scalar == 0)
                throw new CalcException(rm.getString(Message.DIVBYZERO) + this + "/" + scalar);
            for (int i = 0; i < this.value.length; i++) {
                matrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
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
