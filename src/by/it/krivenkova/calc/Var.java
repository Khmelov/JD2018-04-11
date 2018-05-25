package by.it.krivenkova.calc;

import java.util.HashMap;
import java.util.Map;

class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();

    static Var saveVar(String key, Var var) {
        vars.put(key,var);
        return var;
    }

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        else
            throw new CalcException("ERROR:  " + strVar);
      //  return null;
    }

    @Override
    public String toString() {
        return "Это абстрактная переменная";
    }

    @Override
    public Var add(Var other) throws CalcException{
        System.out.println("Операция сложения "+this+"+"+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) throws CalcException{
        System.out.println("Операция вычитания "+this+"-"+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException{
        System.out.println("Операция умножения "+this+"*"+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException{
        System.out.println("Операция деления "+this+"/"+other+" невозможна");
        return null;
    }

}
