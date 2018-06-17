package by.it.gavrilchik.calc;

class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String strVar) {
        super(); //todo Create Matrix from String
    }

    @Override
    public String toString() {
        return "Just some Matrix";
    }
}
