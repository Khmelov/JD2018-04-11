package by.it.kashayed.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcExeption{

        String [] operands = expression.split(Patterns.OPERATION);
        Var first = Var.createVar(operands[0]);
        Var second = Var.createVar(operands[1]);
        if(expression.contains("=")){
            return Var.numbers(operands[0],second);
        }
        if (first==null || second==null)         return null;
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher =pattern.matcher(expression);
        if (matcher.find()){
            switch (matcher.group()){
                case "+": return first.add(second);
                case "-": return first.sub(second);
                case "*": return first.mul(second);
                case "/": return first.div(second);
                case "=": return first.asg(second);
            }
        }
        return null;
    }

}
