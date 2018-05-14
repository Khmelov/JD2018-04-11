package by.it.shumilov.jd01_09;

class Var implements  Operation {

    static Var createVar(String strVar){
        if(strVar.matches(Patterns.SCALAR)) return new Scalar(strVar);
        else if(strVar.matches(Patterns.VECTOR)) return new Vector(strVar);
        else if(strVar.matches(Patterns.MATRIX)) return new Matrix(strVar);
        return null;  //todo generate Some error(Exc)
    }

    @Override
    public String toString() {
        return "Abstract";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "   + this + "+" + other + "невозможена");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "   + this + "+" + other + "невозможена");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "   + this + "+" + other + "невозможена");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "   + this + "+" + other + "невозможена");
        return null;
    }
}

