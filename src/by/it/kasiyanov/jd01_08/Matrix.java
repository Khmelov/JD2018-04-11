package by.it.kasiyanov.jd01_08;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix (double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix (String str){

        String arr[] = str.split("},");
        double [][] res = new double [arr.length][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("{", " ").replace("}"," ").trim();
            String tmp[] = arr[i].split(",");
            res [i] = new double[tmp.length];
            for (int j = 0; j < tmp.length; j++) {
                res[i][j] = Double.parseDouble(tmp[j]);
            }
        }
        this.value = res;

    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [][] res = new double [value.length][];
            for (int i = 0; i < res.length; i++) {
                res [i] = new double[value[i].length];
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Matrix && value.length == ((Matrix) other).value.length
                && value[0].length == ((Matrix) other).value[0].length) {
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new double[value[i].length];
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double [][] res = new double [value.length][];
            for (int i = 0; i < res.length; i++) {
                res [i] = new double[value[i].length];
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Matrix && value.length == ((Matrix) other).value.length
                && value[0].length == ((Matrix) other).value[0].length) {
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new double[value[i].length];
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        else {
            return super.add(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double [][] res = new double [value.length][];
            for (int i = 0; i < res.length; i++) {
                res [i] = new double[value[i].length];
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Vector && value.length == ((Vector) other).getValue().length) {
            double[] vectres = new double[((Vector) other).getValue().length];

            for (int i = 0; i < value.length; i++) {
                double mul = 0;
                for (int j = 0; j < vectres.length; j++) {
                    mul = mul + value[i][j] * ((Vector) other).getValue()[j];
                }
                vectres[i] = mul;
            }
            return new Vector(vectres);
        }
        else if(other instanceof Matrix && value.length == ((Matrix) other).value[0].length) {
            double[][] res = new double[value.length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new double[value[i].length];
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    double mul = 0;
                    for (int k = 0; k < res.length; k++) {
                        mul = mul + value[i][k] * ((Matrix) other).value[k][j];
                    }
                    res[i][j] = mul;
                }
            }
            return new Matrix(res);
        }
        else {
            return super.add(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        String arrdelimetr = "";

        for (int i = 0; i < value.length; i++) {
            sb.append(arrdelimetr).append("{");
            delimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            sb.append("}");
            arrdelimetr = ", ";
        }
        sb.append("}");

        return sb.toString();


    }
}
