package by.it.mokhart.jd01_08;


abstract class Var implements Operation {
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
