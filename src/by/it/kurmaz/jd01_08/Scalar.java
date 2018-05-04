package by.it.kurmaz.jd01_08;

public class Scalar extends Var {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.getValue();
    }

    public Scalar (String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar)
            return new Scalar (this.value + ((Scalar) other).value);
        else
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar)
            return new Scalar (this.value - ((Scalar) other).getValue());
        else
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar)
            return new Scalar (this.value * ((Scalar) other).getValue());
        else
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar)
            return new Scalar (this.value / ((Scalar) other).getValue());
        else
        return other.div(this);
    }

    double getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(value);
    }



}
