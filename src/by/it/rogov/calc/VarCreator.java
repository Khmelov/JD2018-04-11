package by.it.rogov.calc;

 class VarCreator {

     static Var createVar(String strVar)   {
         if (strVar.matches(Patterns.SCALAR))
             return new Scalar(strVar);
         else if (strVar.matches(Patterns.VECTOR))
             return new Vector(strVar);
         else if (strVar.matches(Patterns.MATRIX))
             return new Matrix(strVar);
         else if (Printer.vars.containsKey(strVar))
             return Printer.vars.get(strVar);
         return  null;
     }

}