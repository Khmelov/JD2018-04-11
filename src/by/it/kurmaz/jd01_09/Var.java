package by.it.kurmaz.jd01_09;

public abstract class Var implements Operation {

    static Var createVar(String line) {
        if (line.matches(Patterns.SCALAR))
            return new Scalar(line);
        else if (line.matches(Patterns.VECTOR))
            return new Vector(line);
        else if (line.matches(Patterns.MATRIX))
            return new Matrix(line);
        else
            return null;
    }
    
    @Override
    public abstract String toString();

    @Override
    public Var add(Var other) {
        System.out.println("Add operation with " + this + " and " + other + " cannot be completed");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Sub operation with " + this + " and " + other + " cannot be completed");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Multiply operation with " + this + " and " + other + " cannot be completed");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Divide operation with " + this + " and " + other + " cannot be completed");
        return null;
    }
}
