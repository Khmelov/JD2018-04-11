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

    double getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(value);
    }



}
