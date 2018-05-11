package by.it.kashayed.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression){

        String [] operands = expression.split(Patterns.OPERATION);
        Var first = Var.createVar(operands[0]);
        Var second = Var.createVar(operands[1]);
        if (first==null || second==null)         return null;
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher =pattern.matcher(expression);
        if (matcher.find()){
            switch (matcher.group()){
                case "+": return first.add(second);
                case "-": return first.sub(second);
                case "*": return first.mul(second);
                case "/": return first.div(second);
            }
        }
        return null;
    }

}
