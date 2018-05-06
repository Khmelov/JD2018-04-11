package by.it.akhmelev.jd01_08;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    //    public void scalarPubMeth(){
//        System.out.println("scalarPubMeth");
//    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value + ((Scalar) other).value);
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value - ((Scalar) other).value);
        else
            return other.mul(new Scalar(-1)).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value * ((Scalar) other).value);
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value / ((Scalar) other).value);
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
