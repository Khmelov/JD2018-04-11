package by.it.lanevich.calc;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

abstract class Var implements Operation {

private static Map<String, Var> hashVar = new HashMap<>();

static void printVar(){

        for(Map.Entry<String, Var> item :hashVar.entrySet()){
            System.out.printf("%s=%s \n", item.getKey(), item.getValue());}
    }

    static void sortVar(){

        Comparator<Map.Entry<String, Var>> comp = (Map.Entry<String, Var> o1, Map.Entry<String, Var> o2) -> (o1.getKey().compareTo(o2.getKey()));
        TreeSet<Map.Entry<String, Var>> sorted = new TreeSet<>(comp);
        sorted.addAll(hashVar.entrySet());
        for (Map.Entry<String, Var> entry : sorted) {
            System.out.println(entry.toString());
        }
    }

static Var saveVar (String key, Var var){
    hashVar.put(key,var);
    return var;

}

    static Var createVar(String operand) throws CalcException{
        operand=operand.trim().replace("\\s+","");
        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        throw new CalcException("Невозможно создать"+operand);

    }


    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
         }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания " + this + "-" + other + " невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");

    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");

    }
}

