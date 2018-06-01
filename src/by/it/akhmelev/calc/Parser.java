package by.it.akhmelev.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static Map<String, Integer> priorityMap = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private List<String> operations;
    private List<String> operands;

    private int getNumberOp() {
        int pos = -1;
        int level = -1;
        for (int i = 0; i < operations.size(); i++) {
            String currentOp = operations.get(i);
            if (level < priorityMap.get(currentOp)) {
                level = priorityMap.get(currentOp);
                pos = i;
            }
        }
        return pos;
    }


    private void debug() {
        System.out.print(operands.get(0));
        for (int i = 0; i < operations.size(); i++) {
            System.out.print(operations.get(i) + operands.get(i + 1));
        }
        System.out.println();
    }


    private Var oneOperation(String left, String op, String right) throws CalcException {
        // A=1+-2+-3-6*-9-8/-7
        Var two = Var.createVar(right);
        if (op.equals("=")) {
            return Var.saveVar(left, two);
        }
        Var one = Var.createVar(left);
        if (one == null || two == null)
            throw new CalcException(
                    String.format("Невозмажно обработать %s%s%s", left, op, right)
            );
        switch (op) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }

        throw new CalcException(
                String.format("Неизвестная ошибка %s%s%s", left, op, right)
        );
    }


    Var calc(String expression) throws CalcException {
        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        Pattern patternOp = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOp.matcher(expression);
        operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        Var res = Var.createVar(expression);
        while (operations.size() > 0) {
            int num = getNumberOp();
            String left = operands.remove(num);
            String op = operations.remove(num);
            String right = operands.get(num);
            //debug();
            res = oneOperation(left, op, right);
            operands.set(num, res.toString());
        }

        return res;

    }


}
