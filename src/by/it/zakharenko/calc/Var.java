package by.it.zakharenko.calc;

import java.util.HashMap;
import java.util.Map;

import static by.it.zakharenko.calc.ConsoleRunner.rm;

public class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    public static Var saveVar(String key, Var var) {
        vars.put(key, var);
        return var;
    }

    static Var createVar(String strVar) {

        if (strVar.matches(Patterns.SCALAR))
            return new Scalar((strVar));

        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);

        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);

        else if (vars.containsKey(strVar))
            return vars.get(strVar);

        return null;
    }


    @Override
    public String toString() {
        return rm.getString(Message.ABSTRACTVAR);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(rm.getString(Message.ADD) + " " + this + "+" + other + " " + rm.getString(Message.IMPOSSIBLE));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(rm.getString(Message.SUB) + " " + this + "-" + other + " " + rm.getString(Message.IMPOSSIBLE));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(rm.getString(Message.MUL) + " " + this + "*" + other + " " + rm.getString(Message.IMPOSSIBLE));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(rm.getString(Message.DIV) + " " + this + "/" + other + " " + rm.getString(Message.IMPOSSIBLE));
    }

}
