package by.it.shumilov.jd01_08;

public  class Var implements  Operation {



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

