package by.it.lanevich.calc3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import static by.it.lanevich.calc3.ConsoleRunner.rm;

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

    @Override
    public String toString() {
        return rm.getString(Messages.ABSTRACTVAR);
    }


    static Var createVar(String operand) throws CalcException{
       // operand=operand.replace("\\s+","").trim();
        operand=operand.replaceAll("\\s+","").trim();
        VarFactory.Creator creator = null;
        if(operand.matches(Patterns.SCALAR))
            creator = new VarFactory.CreatorScalar();
        if(operand.matches(Patterns.VECTOR))
            creator = new VarFactory.CreatorVector();
        if(operand.matches(Patterns.MATRIX))
            creator = new VarFactory.CreatorMatrix();
        if (operand.matches(Patterns.VARNAME))
            return hashVar.get(operand);
        if (creator == null)
        throw new CalcException(rm.getString(Messages.CREATEIMPOSSIBLE)+operand);
        return creator.parse(operand);
    }


    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException(rm.getString(Messages.ADD) + this + "+" + other + rm.getString(Messages.IMPOSSIBLE));
         }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException(rm.getString(Messages.SUB) + this + "-" + other + rm.getString(Messages.IMPOSSIBLE));

    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(rm.getString(Messages.MUL) + this + "*" + other + rm.getString(Messages.IMPOSSIBLE));

    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(rm.getString(Messages.DIV) + this + "/" + other + rm.getString(Messages.IMPOSSIBLE));

    }
}

