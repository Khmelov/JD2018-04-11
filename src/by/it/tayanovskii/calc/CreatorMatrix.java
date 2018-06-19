package by.it.tayanovskii.calc;

public class CreatorMatrix extends CreatorVar {
    @Override
    public Var createVar(String strVar) {
        return new Matrix(strVar);
    }
}
