package by.it.kurmaz.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc (String expression) {
        expression = expression.trim().replaceAll("\\s+", "");
        String[] operands = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);
        if ((one == null) || (two == null))
            return null;
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }

        return null;
    }

}
