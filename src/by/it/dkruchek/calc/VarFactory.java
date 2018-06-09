package by.it.dkruchek.calc;

import java.util.HashMap;
import java.util.Map;

public class VarFactory {
    private static ResMan rm = ResMan.getInstance();
    private static Logger logger = Logger.getLogger();

    static Var getVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (Var.vars.containsKey(strVar)) {
            return Var.vars.get(strVar);
        } else {
            logger.log(rm.getString(VarError.UNSUPPORTED_TYPE) + " " + strVar, LogLevel.ERROR);
            throw new CalcException(rm.getString(VarError.UNSUPPORTED_TYPE) + " " + strVar);
        }

    }
}