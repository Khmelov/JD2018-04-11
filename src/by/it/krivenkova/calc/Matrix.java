package by.it.krivenkova.calc;

class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String strVar) {
        super();
    }

    @Override
    public String toString() {
        return "Just some Matrix";
    }
}
