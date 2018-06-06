package by.it.obmetko.calc;
import static by.it.obmetko.calc.ConsoleRunner.rm;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }
    Scalar (String str){
        this.value=Double.parseDouble(str);
    }
    Scalar (Scalar scalar){
        this.value=scalar.value;
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value + ((Scalar) other).value);
        return other.add(this);
    }

    @Override
    public Var sub(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double res = this.value - ((Scalar) other).value;
            return new Scalar(res);
        }
        return new Scalar(-1).mul(other.add(this));

    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double res = this.value * ((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double z = ((Scalar) other).getValue();
            if (z == 0)
                throw new CalcException(rm.get(Messages.DIVBYZERO));
            else
                return this.mul(new Scalar(1 / ((Scalar) other).getValue()));
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
