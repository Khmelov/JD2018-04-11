package by.it.tayanovskii.calc;

public class CreatorVector extends CreatorVar {
    @Override
    public Var createVar(String strVar) {
        return new Vector(strVar);
    }
}
