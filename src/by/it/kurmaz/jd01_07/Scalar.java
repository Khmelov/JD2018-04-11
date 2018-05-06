package by.it.kurmaz.jd01_07;

public class Scalar extends AbstractVar {
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
