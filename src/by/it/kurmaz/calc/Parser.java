package by.it.kurmaz.calc;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc (String expression) throws CalcException {
        HashMap<String, Var> hashMap = new HashMap<>();
        expression = expression.trim().replaceAll("\\s+", "");

        if (expression.contains("=")) {
            String[] operands = expression.split("=");
            String key = operands[0];
            Var value = Var.createVar(operands[1]);
            hashMap.put(key, value);
        }
        else if (expression.contains(Patterns.PRINTVAR))
            Variables.printHash(hashMap);
        else if (expression.contains(Patterns.SORTVAR))
            Variables.printSort(hashMap);
        else {
            String[] operands = expression.split(Patterns.OPERATION);
            Var one = Var.createVar(operands[0]);
            Var two = Var.createVar(operands[1]);

            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);
            if (matcher.find()) {
                String operation = matcher.group();
                switch (operation) {
                    case "+":
                        return one.add(two);
                    case "-":
                        return one.sub(two);
                    case "*":
                        return one.mul(two);
                    case "/":
                        return one.div(two);
                }
            }
        }
        return null;
    }
}
