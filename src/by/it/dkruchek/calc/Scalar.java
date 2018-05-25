package by.it.dkruchek.calc;

import by.it._examples_.jd01_11.Generics.Demo;

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
    public Var add(Var other)  throws CalcException{
        if (other instanceof Scalar) {

            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        if (other instanceof Scalar) {

            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.mul(new Scalar(-1)).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {

            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws ArithmeticException, CalcException{
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0){
                throw new CalcException("Division by zero");
            }
            return new Scalar(this.value / ((Scalar) other).value);
        }
        if (other instanceof Vector){
            throw new CalcException("Scalar by Vector division");
        }
        return super.div(other);
    }

    public double getValue() {
        return value;
    }
}
