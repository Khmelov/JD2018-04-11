package by.it.kashayed.jd02_04.jd02_04new;


import java.util.HashMap;
import java.util.Map;

public class Var implements Operation{

    private static Map<String, Var> map = new HashMap<>();
    private static Map<String, Var> maps = new HashMap<>();
    static Var numbers (String name , Var number){
        map.put(name,number);
        return number;
    }


    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
        else if (map.containsKey(operand)) return map.get(operand);
        else
      //  throw new CalcException("невозможно создать "+operand);
        return null;
    }
    @Override
    public String toString() {
        return "Это абстрактная переменная";
    }

    @Override
    public Var add(Var other) throws CalcException {
       throw new CalcException("Операция сложения "+this+"+"+other+" невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+" невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+" невозможна");

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+" невозможна");

    }

    public Var asg(Var other) {
        System.out.println("Операция присваивания "+this+"="+other+" невозможна");
        return null;
    }

}
