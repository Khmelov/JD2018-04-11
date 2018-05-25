package by.it.krivenkova.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException{
        // два + три
        expression=expression.trim().replaceAll("\\s+","");
        String[] operands = expression.split(Patterns.OPERATION);
        Var two= Var.createVar(operands[1]);
        if (expression.contains("=")){
            return Var.saveVar(operands[0],two);
        }
        Var one= Var.createVar(operands[0]);
        if (one==null || two==null)
            return null;
        Pattern pattern=Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            String operation=matcher.group();
            switch (operation) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return one;
    }
}
