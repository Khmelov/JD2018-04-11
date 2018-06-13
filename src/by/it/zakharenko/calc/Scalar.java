package by.it.zakharenko.calc;

import static by.it.zakharenko.calc.ConsoleRunner.rm;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {   //из вещественного числа
        this.value = value;
    }

    Scalar(Scalar otherScalar) {  //из такой же переменной
        this.value = otherScalar.value;
    }

    Scalar(String strValue) {    //из строки
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value + ((Scalar) other).value);
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value - ((Scalar) other).value);
        else
            return other.mul(new Scalar((-1)).add(this));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value * ((Scalar) other).value);
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double div = ((Scalar) other).value;
            if (div == 0)
                throw new CalcException(rm.getString(Message.DIVBYZERO));
            return new Scalar(this.value / div);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
