package by.it.zakharenko.calc;

import java.util.Arrays;

import static by.it.zakharenko.calc.ConsoleRunner.rm;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {  //из массива
        this.value = value;
    }

    public Vector(Vector otherVector) {  //из такой же переменной
        this.value = Arrays.copyOf(otherVector.value, otherVector.value.length);
    }

    public Vector(String strVector) {  //из строки
        String[] strValues = strVector
                .replaceAll("[{|}]", "")
                .trim()
                .split(",\\s*");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] += scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            Vector otherVector = (Vector) other;
            if (this.value.length != otherVector.value.length)
                throw new CalcException(rm.getString(Message.VECTORDIFFERENTSIZES) + this + "+" + other);
            for (int i = 0; i < vector.length; i++) {
                vector[i] += ((Vector) other).value[i];
            }
            return new Vector(vector);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            Vector otherVector = (Vector) other;
            if (this.value.length != otherVector.value.length)
                throw new CalcException(rm.getString(Message.VECTORDIFFERENTSIZES) + this + "-" + other);
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= ((Vector) other).value[i];
            }
            return new Vector(vector);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= scalar;
            }
            return new Vector(vector);
        } else if (other instanceof Vector) {
            double sum = 0;
            Vector otherVector = (Vector) other;
            if (this.value.length != otherVector.value.length)
                throw new CalcException(rm.getString(Message.VECTORDIFFERENTSIZES) + this + "*" + other);
            for (int i = 0; i < this.value.length; i++) {
                sum += this.value[i] * otherVector.value[i];
            }
            return new Scalar(sum);
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            if (scalar == 0)
                throw new CalcException(rm.getString(Message.DIVBYZERO) + " " + this + "/" + scalar);
            for (int i = 0; i < vector.length; i++) {
                vector[i] /= scalar;
            }
            return new Vector(vector);
        } else
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
        return this.value;
    }
}


