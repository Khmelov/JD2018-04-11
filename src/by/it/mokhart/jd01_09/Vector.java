package by.it.mokhart.jd01_09;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector) {
            double[] add = Arrays.copyOf(value, value.length);
            for (int i = 0; i < add.length; i++) {
                add[i] = add[i] + ((Vector) other).value[i];
            }
            return new Vector(add);
        } else if (other instanceof Scalar) {
            double[] add = Arrays.copyOf(value, value.length);
            for (int i = 0; i < add.length; i++) {
                add[i] = add[i] + ((Scalar) other).getValue();
            }
            return new Vector(add);
        } else return other.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Vector) other).value[i];
            }
            return new Vector(sub);
        } else if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(value, value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] = sub[i] - ((Scalar) other).getValue();
            }
            return new Vector(sub);
        } else return other.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double sum = 0;
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] = mul[i] * ((Vector) other).value[i];
                sum = sum + mul[i];
            }
            return new Scalar(sum);
        } else if (other instanceof Scalar) {
            double sum = 0;
            double[] mul = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] = mul[i] * ((Scalar) other).getValue();
                //sum = sum + mul[i];
            }
            return new Vector(mul);
        } else return other.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] div = Arrays.copyOf(value, value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] = div[i] / ((Scalar) other).getValue();
            }
            return new Vector(div);
        } else return null;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
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
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        String delimetr = "";
        for (double v : value) {
            builder.append(delimetr).append(v);
            delimetr = ", ";
        }
        builder.append("}");
        return builder.toString();
    }
}
