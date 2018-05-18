package by.it.dkruchek.calc;

/**
 * Created by Dmitriy.Kruchek on 4/25/2018.
 */
public class Scalar extends Var {

    private double value;

    public Scalar(double value) {

        this.value = value;
    }

    public Scalar(Scalar scalar) {

        this.value = scalar.value;
    }

    public Scalar(String strScalar) {

        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {

        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {

            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {

            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.mul(new Scalar(-1)).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {

            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws ArithmeticException {
        if (other instanceof Scalar) {

            return new Scalar(this.value / ((Scalar) other).value);
        }
        return super.div(other);
    }

    public double getValue() {
        return value;
    }
}
