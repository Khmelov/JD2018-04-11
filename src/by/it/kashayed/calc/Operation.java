package by.it.kashayed.calc;


interface Operation {
    Var add(Var other)throws CalcExeption;
    Var sub(Var other)throws CalcExeption;
    Var mul(Var other)throws CalcExeption;
    Var div(Var other)throws CalcExeption;
    Var asg(Var other)throws CalcExeption;
}
