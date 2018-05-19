package by.it.lanevich.jd01_09;

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

//        Pattern pattern = Pattern.compile("[{}]{2,}");
//        Matcher matcher = pattern.matcher(strMatrix);
//        while (matcher.find()) {
//            strMatrix = matcher.replaceAll("");
//        }
//
//        String[] s = strMatrix.split("},\\{");
//
//        double[][] m = new double[s.length][s.length];
//        for (int i = 0; i < s.length; i++) {
//            String[] str = s[i].split(",");
//            for (int j = 0; j < str.length; j++) {
//                m[i][j] = Double.parseDouble(str[j]);
//            }
//        }

        String[] s = strMatrix.split("},");
        Pattern pattern = Pattern.compile("[{}]");
        for (int i = 0; i < s.length; i++) {
            Matcher matcher = pattern.matcher(s[i]);
            while (matcher.find()) {
                s[i] = matcher.replaceAll("");
            }
        }

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
        //сложение матрицы со скаляром
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                //  for (int j = 0; j < value.length; j++) {
                //  res[i][j] = value[i][j];
                System.arraycopy(value[i], 0, res[i], 0, value.length);
                //  }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else
            //сложение матрицы с вектором - операция невозможна
            if (other instanceof Vector) {
                return super.add(other);
            }
            //сложение матрицы с матрицей
            else {
                double[][] res = new double[value.length][value.length];
                for (int i = 0; i < value.length; i++) {
                    System.arraycopy(value[i], 0, res[i], 0, value.length);
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
        //вычитание из матрицы скаляра
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                System.arraycopy(value[i], 0, res[i], 0, value.length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else
            //вычитание из матрицы вектора - операция невозможна
            if (other instanceof Vector) {
            return super.add(other);
        }
            //вычитание из матрицы матрицы
            else {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                System.arraycopy(value[i], 0, res[i], 0, value.length);
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
        //умножение матрицы на скаляр
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                System.arraycopy(value[i], 0, res[i], 0, value.length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else
            //умножение матрицы на вектор
            if (other instanceof Vector) {
            double[] res = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i] = res[i] + value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(res);
        }
            //умножение матрицы на матрицу
            else {
            double[][] cop = new double[value.length][value.length];
            for (int i = 0; i < value.length; i++) {
                System.arraycopy(value[i], 0, cop[i], 0, value.length);
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
        //операция деления невозможна
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
