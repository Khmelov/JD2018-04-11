package by.it.tayanovskii.calc;

import java.util.*;

class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();


    static Var saveVar(String key, Var var) {

        vars.put(key, var);
        return var;
    }

    static Var createVar(String strVar) throws CalcException{
        CreatorVar creatorVar=null;
        if (strVar.matches(Patterns.SCALAR))
            creatorVar=new CreatorScalar();
            //return creatorVar.createVar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            creatorVar=new CreatorVector();
            //return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
           creatorVar=new CreatorMatrix();
            //return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        if(creatorVar==null)
            return null;
        return creatorVar.createVar(strVar);

//        if (strVar.matches(Patterns.SCALAR))
//            return new Scalar(strVar);
//        else if (strVar.matches(Patterns.VECTOR))
//            return new Vector(strVar);
//        else if (strVar.matches(Patterns.MATRIX))
//            return new Matrix(strVar);
//        else if (vars.containsKey(strVar))
//            return vars.get(strVar);
//        return null;
   }

    public static String printvar() {
        String result=null;
        for (Map.Entry<String, Var> entry : vars.entrySet()) {
            result=entry.getKey() + "=" + entry.getValue();
            System.out.println(result);
        }
        return result;
    }

    public static void sortvar() {

        Map<String, Var> sortedMap = new TreeMap<>(vars);
        for (Map.Entry<String, Var> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }


    @Override
    public String toString() {
        return ResMan.getString(Message.abstractVariable);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResMan.getString(Message.additionImpossible) + this + "+" + other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResMan.getString(Message.subtractionImpossible) + this + "-" + other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResMan.getString(Message.multiplicationImpossible) + this + "*" + other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResMan.getString(Message.divisionImpossible) + this + "/" + other);
    }


}
