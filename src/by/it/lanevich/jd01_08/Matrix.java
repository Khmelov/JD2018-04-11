package by.it.lanevich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;


    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {

        Pattern pattern = Pattern.compile("[{}]{2,}");
        Matcher matcher = pattern.matcher(strMatrix);
        while (matcher.find()) {
            strMatrix = matcher.replaceAll("");
        }

        String[] s = strMatrix.split("},\\{");

        double[][] m = new double[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            String[] str = s[i].split(",");
            for (int j = 0; j < str.length; j++) {
                m[i][j] = Double.parseDouble(str[j]);
            }
        }
        this.value = m;
    }


    @Override
    public Var add(Var other) {

        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            return super.add(other);
        } else {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);

        }

    }


    @Override
    public Var sub(Var other) {

        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {


            return super.add(other);


        } else {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);

        }

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[] res = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i] = res[i] + value[i][j] * ((Vector) other).getValue()[j];
                }
            }

            return new Vector(res);


        } else {
            double[][] cop = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    cop[i][j] = value[i][j];
                }
            }


            double[][] res = new double[value.length][value.length];

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    for (int k = 0; k < res.length; k++) {

                        res[i][j] = res[i][j] + cop[i][k] * (((Matrix) other).value[k][j]);
                    }

                }
            }
            return new Matrix(res);

        }
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {

                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
            delimiter = ", {";
        }
        sb.append("}");
        return sb.toString();
    }
}
