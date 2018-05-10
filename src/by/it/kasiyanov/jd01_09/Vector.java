package by.it.kasiyanov.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double [] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value){
        this.value = value;
    }

    Vector (Vector vector){
        this.value = vector.value;
    }

    Vector (String str){
        str = str.replace("{", " ").replace("}"," ").trim();
        str = str.replace(","," ");
        String strArr[] = str.split(" ");

        double[] tmp = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            tmp [i] = Double.parseDouble(strArr[i]);
        }
        this.value = tmp;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else {
            return super.add(other);
        }

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            double mul = 0;
            for (int i = 0; i < res.length; i++) {
                mul = mul + res[i] * ((Vector) other).value[i];
            }
            return new Scalar(mul);
        }
        else {
            return super.add(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else {
            return super.add(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");

        return sb.toString();
    }
}
