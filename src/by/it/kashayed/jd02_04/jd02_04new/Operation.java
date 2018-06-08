package by.it.kashayed.jd02_04.jd02_04new;


interface Operation {
    Var add(Var other)throws CalcException;
    Var sub(Var other)throws CalcException;
    Var mul(Var other)throws CalcException;
    Var div(Var other)throws CalcException;
    Var asg(Var other)throws CalcException;
}
