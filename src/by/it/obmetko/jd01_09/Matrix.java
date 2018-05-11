package by.it.obmetko.jd01_09;

import java.util.Arrays;

public class Matrix extends Var {
    private double value[][];

    Matrix() {
    }

    Matrix(double[][] value) {
        this.value = new double[value.length][];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][];
        for (int i = 0; i < matrix.value.length; i++) {
            this.value[i] = Arrays.copyOf(matrix.value[i], matrix.value[i].length);
        }
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{]+", "") + "},";
        String lines[] = strMatrix.split("[}]+,");
        value = new double[lines.length][];
        String line[];
        for (int i = 0; i < lines.length; i++) {
            line = lines[i].split(",");
            value[i] = new double[line.length];
            for (int j = 0; j < line.length; j++) {
                value[i][j] = Double.parseDouble(line[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            result.append("{").append(Arrays.toString(value[i]).replaceAll("[\\[\\]]", "")).append("}");
            if (i < value.length - 1)
                result.append(", ");
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = this.value.clone();
            for (int i = 0; i < this.value.length; i++) {
                res[i] = this.value[i].clone();
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);


        } else if (other instanceof Matrix) {
            if ((this.value.length == ((Matrix) other).value.length) && (this.value[0].length == ((Matrix) other).value[0].length)) {
                double[][] res = this.value.clone();
                for (int i = 0; i < this.value.length; i++) {
                    res[i] = this.value[i].clone();
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            } else return super.add(other);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return this.add(other.mul(new Scalar(-1)));
        } else if (other instanceof Matrix) {
            return this.add(other.mul(new Scalar(-1)));
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, mul[i], 0, this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[i].length; j++) {
                    mul[i][j] *= v;
                }
            }
            return new Matrix(mul);
        } else if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] v = vector.getValue();
            double[] mulVector = new double[v.length];
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, mul[i], 0, this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < v.length; j++) {
                    mulVector[i] += mul[i][j] * v[j];
                }
            }
            return new Vector(mulVector);
        } else {
            double[][] mul = new double[this.value.length][this.value[0].length];
            double[][] mulMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, mul[i], 0, this.value[i].length);
            }
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    for (int k = 0; k < mul[i].length; k++) {
                        mulMatrix[i][j] += mul[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mulMatrix);
        }

    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double v = scalar.getValue();
            double[][] div = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, div[i], 0, this.value[i].length);
            }
            for (int i = 0; i < div.length; i++) {
                for (int j = 0; j < div[i].length; j++) {
                    div[i][j] /= v;
                }
            }
            return new Matrix(div);
        } else
            return super.div(other);
    }
}