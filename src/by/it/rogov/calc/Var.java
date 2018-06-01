package by.it.rogov.calc;



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

class Var implements Operation {

     static Map<String, Var> vars = new HashMap<>();
     static    String filename= Path.path("vars.txt");

     static Var saveVar(String key, Var var) {
        vars.put(key, var);
        try(
                PrintWriter printWriter = new PrintWriter(
                        new FileWriter(filename))
                ) {
            for (Map.Entry<String, Var> stringVarEntry : vars.entrySet()) {

                printWriter.println(stringVarEntry.getKey()+"="+stringVarEntry.getValue());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return var;
    }

    static Var createVar(String strVar) throws CalcException  {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw  new CalcException("Невозможно создать: "+ strVar);
    }

    @Override
    public String toString() {
        return "Это абстрактная переменная";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + "+" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "+" + other + " невозможна");
    }
}
