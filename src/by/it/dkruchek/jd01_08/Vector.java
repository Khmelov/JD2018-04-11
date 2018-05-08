package by.it.dkruchek.jd01_08;

import java.util.Arrays;

/**
 * Created by Dmitriy.Kruchek on 4/25/2018.
 */
public class Vector extends Var {

    private double[] value;

    public Vector(String strVector) {
        String[] values = strVector.replaceAll("[{}]", "")
                .trim()
                .split(",\\s*");
        value = new double[values.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(values[i]);
        }
    }

    public Vector(double[] array){

        this.value = array;
    }

    public Vector(Vector vector){

        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] += scalar;
            }
            return new Vector(vector);
        }
        else if (other instanceof Vector){
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
        if (other instanceof Scalar){
            return this.add(other.mul(new Scalar(-1)));
        }
        else if (other instanceof Vector){
            return this.add(other.mul(new Scalar(-1)));
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= scalar;
            }
            return new Vector(vector);
        }
        else if (other instanceof Vector){
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= ((Vector) other).value[i];
            }
            double sum = 0;
            for (double v : vector) {
                sum += v;
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws ArithmeticException {
        if (other instanceof Scalar){
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] /= scalar;
            }
            return new Vector(vector);
        }
        return super.div(other);
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
        return value;
    }
}
