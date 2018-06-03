package by.it.kurmaz.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private List<String> operations;

    private int getOperationIndex() {
        int pos = -1;
        int level = -1;
        for (int i = 0; i < operations.size(); i++) {
            String currentOp = operations.get(i);
            if (level < priority.get(currentOp)) {
                level = priority.get(currentOp);
                pos = i;
            }
        }
        return pos;
    }

    String processLine(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.BRACKETS);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            String calculateLine = matcher.group();
            String result = processLine(calculateLine.replaceAll("[()]", ""));
            expression = expression.replace(calculateLine, result);
            matcher = pattern.matcher(expression);
        }
        Var result = calc(expression);
        if (result == null)
            throw new CalcException("Check expression, calc failed");
        return result.toString();
}

    Var calc (String expression) throws CalcException {
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        Var result = Var.createVar(expression);
        while (operations.size() > 0) {
            int num = getOperationIndex();
            String left = operands.remove(num);
            String op = operations.remove(num);
            String right = operands.get(num);
            result = SingleOperation(left, right, op);
            if (result == null)
                throw new CalcException("Check expression, calc failed");
            operands.set(num, result.toString());
        }
        return result;
    }

    private Var SingleOperation(String var1, String var2, String operand) throws CalcException {
        if (operand.equals("=")) {
            Var var = Var.createVar(var2.trim());
            Variables.hashMap.put(var1.trim(), var);
            System.out.println("Variable " + var1 +  "created");
            return var;
        }
        Var first = Var.createVar(var1.trim());
        Var second = Var.createVar(var2.trim());
        Var result;
        if ((first != null) && (second != null)) {
            switch (operand) {
                case "+":
                    result = first.add(second);
                    Logger.Log(first.toString() + operand + second.toString() + " = " + result.toString());
                    return result;
                case "-":
                    result = first.sub(second);
                    Logger.Log(first.toString() + operand + second.toString() + " = " + result.toString());
                    return result;
                case "*":
                    result = first.mul(second);
                    Logger.Log(first.toString() + operand + second.toString() + " = " + result.toString());
                    return result;
                case "/":
                    result = first.div(second);
                    Logger.Log(first.toString() + operand + second.toString() + " = " + result.toString());
                    return result;
            }
        }
        return null;
    }
}
