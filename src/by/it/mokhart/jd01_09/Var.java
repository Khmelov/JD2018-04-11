package by.it.mokhart.jd01_09;


abstract class Var implements Operation {

    static Var createVar(String operand){
        operand = operand.trim().replace("\\s","");
                if(operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
                }else if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
                }else if(operand.matches(Patterns.MATRIX)){
            return new Matrix(operand);
                }
                return null;
    }

    @Override
    public String toString() {
        return "This is abstract class Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Operation of addition" + this + "+" + other + "is impossible");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Operation of subtraction" + this + "-" + other + "is impossible");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Operation of multiplication" + this + "*" + other + "is impossible");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Operation of division" + this + "/" + other + "is impossible");
        return null;
    }
}
