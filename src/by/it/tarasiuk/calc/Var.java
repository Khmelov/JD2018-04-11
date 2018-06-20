package by.it.tarasiuk.calc;

import java.util.HashMap;
import java.util.Map;

class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+","").trim();
        VarFactory.Creator creator =null;
        if (strVar.matches(Patterns.SCALAR))
            creator = new VarFactory.CreatorScalar();
        else if (strVar.matches(Patterns.VECTOR))
            creator = new VarFactory.CreatorVector();
        else if (strVar.matches(Patterns.MATRIX))
            creator = new VarFactory.CreatorMatrix();
        else if (creator==null)
        throw new CalcException("Невозможно создать " + strVar);
        return creator.parse(strVar);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция ввычитания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }
}
