package by.it.dkruchek.calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitriy.Kruchek on 4/25/2018.
 */
class Var implements Operation {

    private static ResMan rm = ResMan.getInstance();
    static Map<String, Var> vars = new HashMap<>();

    private static Logger logger = Logger.getLogger();
    private static VarFactory varFactory = new VarFactory();

    static Var createVar(String strVar) throws CalcException {
        return varFactory.getVar(strVar);
    }

    @Override
    public String toString() {
        return "Это абстрактная переменная";
    }

    @Override
    public Var add(Var other)  throws CalcException{
        logger.log(rm.getString(VarError.ADD_IMPOSSIBLE), LogLevel.ERROR);
        System.out.println(rm.getString(VarError.ADD_IMPOSSIBLE) + " " + this + " + " + other);
        return null;
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        logger.log(rm.getString(VarError.SUB_IMPOSSIBLE), LogLevel.ERROR);
        System.out.println(rm.getString(VarError.SUB_IMPOSSIBLE) + " " + this + " + " + other);
        return null;
    }

    @Override
    public Var mul(Var other) throws CalcException{
        logger.log(rm.getString(VarError.MUL_IMPOSSIBLE), LogLevel.ERROR);
        System.out.println(rm.getString(VarError.MUL_IMPOSSIBLE) + " " + this + " + " + other);
        return null;
    }

    @Override
    public Var div(Var other) throws ArithmeticException, CalcException {
        logger.log(rm.getString(VarError.DIV_IMPOSSIBLE), LogLevel.ERROR);
        System.out.println(rm.getString(VarError.DIV_IMPOSSIBLE) + " " + this + " + " + other);
        return null;
    }

    static Var saveVar(String key, Var var) {
        vars.put(key, var);
        return var;
    }
}
