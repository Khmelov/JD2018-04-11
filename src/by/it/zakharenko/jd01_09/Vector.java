package by.it.zakharenko.jd01_09;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {  //из массива
        this.value = value;
    }

    Vector(Vector otherVector) {  //из такой же переменной
        this.value = otherVector.value;
    }

    Vector(String strVector) {  //из строки
        String[] strValues = strVector
                .replaceAll("[{|}]", "")
                .trim()
                .split(",\\s*");
        value = new double[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            value[i] = Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] += scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < vector.length; i++) {
                vector[i] += ((Vector) other).value[i];
            }
            return new Vector(vector);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= ((Vector) other).value[i];
            }
            return new Vector(vector);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double sum = 0;
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < vector.length; i++) {
                sum += vector[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] /= scalar;
            }
            return new Vector(vector);
        }
        return null;
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

    public double[] getValue() {
        return this.value;
    }
}


