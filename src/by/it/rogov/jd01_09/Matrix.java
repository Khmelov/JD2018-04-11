package by.it.rogov.jd01_09;




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

                }
            }
            return new Matrix(matrix);
        }

        if (other instanceof Vector) {
            double[][] matrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    matrix[i][j] = value[i][j];
                }
            }
            double [] res = new double[((Vector) other).getValue().length];
            double[] vector = Arrays.copyOf(((Vector) other).getValue(),((Vector) other).getValue().length);
                for (int i = 0; i < matrix.length; i++) {
                    for (int i1 = 0; i1 < vector.length; i1++) {
                        res[i] = res[i] + matrix[i][i1] * vector[i1];
                    }
                }
            return new Vector(res);
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
            int m = matrix1.length;
            int n= matrix2[0].length;
            int o= matrix2.length;
            double[][] res=new double[m][n];
            for (int i = 0; i < m; i++) {
                for (int i1 = 0; i1 < n; i1++) {
                    for (int i2 = 0; i2 < o; i2++) {
                        res[i][i1] = res[i][i1] + matrix1[i][i2] * matrix2[i2][i1];
                    }
                }
            }
            return new Matrix(res);
        } else
            return null;

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
