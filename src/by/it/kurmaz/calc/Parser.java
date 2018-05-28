package by.it.kurmaz.calc;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private HashMap<String, Var> hashMap = new HashMap<>();

    void recover() throws CalcException {
        hashMap = Saver.recover();
    }

    void save () {
        Saver.save(hashMap);
    }

    Var calc (String expression) throws CalcException {
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
                Var result;
                switch (operation) {
                    case "+":
                        result = one.add(two);
                        Logger.Log(one.toString() + operation + two.toString() + " = " + result.toString());
                        return result;
                    case "-":
                        result = one.sub(two);
                        Logger.Log(one.toString() + operation + two.toString() + " = " + result.toString());
                        return result;
                    case "*":
                        result = one.mul(two);
                        Logger.Log(one.toString() + operation + two.toString() + " = " + result.toString());
                        return result;
                    case "/":
                        result = one.div(two);
                        Logger.Log(one.toString() + operation + two.toString() + " = " + result.toString());
                        return result;
                }
            }
        }
        return null;
    }
}
