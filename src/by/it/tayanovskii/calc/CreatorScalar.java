package by.it.tayanovskii.calc;

public class CreatorScalar extends CreatorVar {

    @Override
    public Var createVar(String strVar) {
        return new Scalar(strVar);
    }
}
