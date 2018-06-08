package by.it.zaliashchonak.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();

    static Var saveVar(String key, Var var) /*throws CalcException */{
        vars.put(key, var);
        try (PrintWriter printer = new PrintWriter(new FileWriter(Util.getPathVarsTxt()))) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printer.println(entry.getKey() + "=" + entry.getValue());
            }
        } catch (IOException e) {
                System.out.println();
        }
        return var;
    }

    static Var createVar(String strVar) /*throws CalcException*/{
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
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
        return "Это абстрактная переменная";
    }

    @Override
    public Var add(Var other) throws CalcException {
        System.out.println("Операция сложения "+this+"+"+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        System.out.println("Операция вычитания "+this+"-"+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException {
        System.out.println("Операция умножения "+this+"*"+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) throws CalcException {
        System.out.println("Операция деления "+this+"/"+other+" невозможна");
        return null;
    }

}
