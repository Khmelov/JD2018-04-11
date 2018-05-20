package by.it.shumilov.Calc;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value){
        this.value = value;
    }

    Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }

    Scalar(String strValue){
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) throws CalcException{
        if(other instanceof Scalar)
            return new Scalar(this.value + ((Scalar) other).value);
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if(other instanceof Scalar)
            return new Scalar(this.value - ((Scalar) other).value);
        else
        return other.mul(new Scalar(-1)).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if(other instanceof Scalar)

            return new Scalar(this.value * ((Scalar) other).value);
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            double z =((Scalar) other).value;
            if (z==0)

                throw new CalcException("Деление на ноль");


        return new Scalar(this.value / z);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
