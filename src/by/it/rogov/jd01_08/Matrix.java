package by.it.rogov.jd01_08;


import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix[i][j] = value[i][j];
                }
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] += scalar;
                }

            }
            return new Matrix(matrix);
        }
        if (other instanceof Matrix) {
            double[][] matrix1 = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix1[i][j] = value[i][j];
                }
            }
            double[][] matrix2 = new double[((Matrix) other).getValue().length][((Matrix) other).getValue()[0].length];
            for (int i = 0; i < ((Matrix) other).getValue().length; i++) {
                for (int j = 0; j < ((Matrix) other).getValue()[0].length; j++) {
                    matrix2[i][j] = ((Matrix) other).getValue()[i][j];
                }
            }
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    matrix1[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return new Matrix(matrix1);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix[i][j] = value[i][j];
                }
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] -= scalar;
                }

            }
            return new Matrix(matrix);
        }
        if (other instanceof Matrix) {
            double[][] matrix1 = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix1[i][j] = value[i][j];
                }
            }
            double[][] matrix2 = new double[((Matrix) other).getValue().length][((Matrix) other).getValue()[0].length];
            for (int i = 0; i < ((Matrix) other).getValue().length; i++) {
                for (int j = 0; j < ((Matrix) other).getValue()[0].length; j++) {
                    matrix2[i][j] = ((Matrix) other).getValue()[i][j];
                }
            }
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    matrix1[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            return new Matrix(matrix1);
        } else
            return super.sub(other);

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix[i][j] = value[i][j];
                }
            }
            double sum = 0;
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] *= scalar;
                    sum += matrix[i][j];
                }
            }
            return new Scalar(sum);
        }

        // переделать умножение матрицу на матрицу...
        if (other instanceof Matrix) {
            double[][] matrix1 = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix1[i][j] = value[i][j];
                }
            }
            double[][] matrix2 = new double[((Matrix) other).getValue().length][((Matrix) other).getValue()[0].length];
            for (int i = 0; i < ((Matrix) other).getValue().length; i++) {
                for (int j = 0; j < ((Matrix) other).getValue()[0].length; j++) {
                    matrix2[i][j] = ((Matrix) other).getValue()[i][j];
                }
            }
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    matrix1[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
            return new Matrix(matrix1);
        } else
            return super.mul(other);

    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] matrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix[i][j] = value[i][j];
                }
            }
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] /= scalar;
                }

            }
            return new Matrix(matrix);
        } else
            return super.div(other);


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
