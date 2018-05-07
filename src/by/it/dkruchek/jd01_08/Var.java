package by.it.dkruchek.jd01_08;

/**
 * Created by Dmitriy.Kruchek on 4/25/2018.
 */
public class Var implements Operation{


    @Override
    public String toString() {

        return "Это абстрактная переменная";

    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) throws ArithmeticException {
        System.out.println("Операция деления " + this + " + " + other + " невозможна");
        return null;
    }
}
