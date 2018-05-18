package by.it.shumilov.Calc;

import java.util.HashMap;
import java.util.Map;

class Var implements  Operation {

    private  static Map<String,Var> vars = new HashMap<>();

    public static  Var saveVar(String key,Var var){
        vars.put(key,var);
        return var;
    }

    static Var createVar(String strVar){
        if(strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if(strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if(strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        return null;  //todo generate Some error(Exc)
    }

    @Override
    public String toString() {
        return "Abstract";
    }

    @Override
    public Var add(Var other) throws CalcException {
        System.out.println("Операция сложения "   + this + "+" + other + "невозможена");
        return null;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.println("Операция вычитания "   + this + "+" + other + "невозможена");
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        System.out.println("Операция умножения "   + this + "+" + other + "невозможена");
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.println("Операция деления "   + this + "+" + other + "невозможена");
        return null;
    }
}

