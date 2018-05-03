package by.it.kashayed.jd01_07;

class Scalar extends AbstractVar {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String scalar){
        this.value=Double.parseDouble(scalar);
    }
    Scalar(Scalar strScalar){
        this.value=strScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
