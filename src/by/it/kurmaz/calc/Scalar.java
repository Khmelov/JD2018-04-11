package by.it.kurmaz.calc;

public class Scalar extends Var {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.getValue();
    }

    public Scalar (String strScalar) {
        strScalar = strScalar.replaceAll("\\s", "");
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) throws CalcException{
        double otherValue;
        if (other instanceof Scalar) {
            otherValue = ((Scalar) other).getValue();
            return new Scalar(this.value + otherValue);
        }
        else
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value - ((Scalar) other).getValue());
        else
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar)
            return new Scalar(this.value * ((Scalar) other).getValue());
        else
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0)
                throw new CalcException("divide by zero");
            return new Scalar(this.value / ((Scalar) other).getValue());
        }
        else
            return super.div(other);
    }

    double getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(value);
    }



}
