package by.it.dkruchek.calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitriy.Kruchek on 4/25/2018.
 */
class Var implements Operation {

    private  static Map<String, Var> vars = new HashMap<>();

    static Var createVar(String strVar) throws CalcException{
        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else if (vars.containsKey(strVar)) {
            return vars.get(strVar);
        }
        else throw new CalcException("Unsupported type for " + strVar);
    }

    @Override
    public String toString() {

        return "Это абстрактная переменная";

    }

    @Override
    public Var add(Var other)  throws CalcException{
        System.out.println("Операция сложения " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        System.out.println("Операция вычитания " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException{
        System.out.println("Операция умножения " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) throws ArithmeticException, CalcException {
        System.out.println("Операция деления " + this + " + " + other + " невозможна");
        return null;
    }

    static Var saveVar(String key, Var var) {
        vars.put(key, var);
        return var;
    }
}
