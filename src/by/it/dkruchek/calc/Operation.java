package by.it.dkruchek.calc;

/**
 * Created by Dmitriy.Kruchek on 5/4/2018.
 */
public interface Operation {

    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws ArithmeticException, CalcException;

}
