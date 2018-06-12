package by.it.krivenkova.calc;

public class VarFactory {
    Var getVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);

        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        return null;
    }
}
