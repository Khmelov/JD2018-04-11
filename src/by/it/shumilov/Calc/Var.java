package by.it.shumilov.Calc;

import java.util.HashMap;
import java.util.Map;

class Var implements  Operation {

    private GetStr getStr = GetStr.getInstance();

    private  static Map<String,Var> vars = new HashMap<>();

    public static  Var saveVar(String key,Var var){
        vars.put(key,var);
        return var;
    }

    static Var createVar(String strVar) throws CalcException {
        if(strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if(strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if(strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        return  null; //throw new CalcException("Неизвестный тип переменной " + strVar);
    }

    @Override
    public String toString() {

        return getStr.getString(Message.ABSTRACT);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s %s + %s %s",getStr.getString(Message.OP),
                                                                getStr.getString(Op.ADD),
                                                                this,
                                                                other,
                                                                getStr.getString(Err.IMP)));

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s %s + %s %s",getStr.getString(Message.OP),
                getStr.getString(Op.SUB),
                this,
                other,
                getStr.getString(Err.IMP)));

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s %s + %s %s",getStr.getString(Message.OP),
                getStr.getString(Op.MUL),
                this,
                other,
                getStr.getString(Err.IMP)));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("%s %s %s + %s %s",getStr.getString(Message.OP),
                getStr.getString(Op.DIV),
                this,
                other,
                getStr.getString(Err.IMP)));

    }
}

