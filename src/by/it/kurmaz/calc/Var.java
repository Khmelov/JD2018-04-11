package by.it.kurmaz.calc;

import java.util.Set;

public abstract class Var implements Operation {

    static Var createVar(String line) throws CalcException {
        if (line.matches(Patterns.SCALAR))
            return new Scalar(line);
        else if (line.matches(Patterns.VECTOR))
            return new Vector(line);
        else if (line.matches(Patterns.MATRIX))
            return new Matrix(line);
        else {
            Set<String> set = Variables.hashMap.keySet();
            for (String entry: set) {
                entry = entry.trim();
                if (entry.equals(line)) {
                    return Var.createVar(Variables.hashMap.get(entry).toString());
                }
            }
            return null;
        }
    }
    
    @Override
    public abstract String toString();

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException ("Add operation with " + this + " and " + other + " cannot be completed");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException ("Sub operation with " + this + " and " + other + " cannot be completed");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException ("Multiply operation with " + this + " and " + other + " cannot be completed");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException ("Divide operation with " + this + " and " + other + " cannot be completed");
    }
}
