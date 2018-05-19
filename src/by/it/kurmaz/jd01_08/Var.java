package by.it.kurmaz.jd01_08;

public abstract class Var implements Operation {
    
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
