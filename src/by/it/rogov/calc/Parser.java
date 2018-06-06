package by.it.rogov.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static Map<String, Integer> priorMap = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }

    };

    String getWords(String exprexion) {
        Pattern pattern = Pattern.compile(Patterns.Worlds);
        Matcher matcher = pattern.matcher(exprexion);
        while (matcher.find()) {
            return (matcher.group());
        }
        return null;
    }

    private List<String> operations;
    private List<String> operands;

    private int getNumberOp() {
        int pos = -1;

        for (int i = 0; i < operations.size(); i++) {
            String currentOp = operations.get(i);
            if (pos < priorMap.get(currentOp)) {
                pos = i;
            }
        }
        return pos;
    }

//    private void debug() {
//        System.out.print(operands.get(0));
//        for (int i = 0; i < operations.size(); i++) {
//            System.out.print(operations.get(i) + operands.get(i));
//        }
//        System.out.println();
//    }

    private Var oneOperation(String left, String op, String rigth) throws CalcException {
        Var two = Var.createVar(rigth);
        if (op.equals("=")) {
            return Var.saveVar(left, two);
        }
        Var one = Var.createVar(left);
        if (one == null || two == null) {
            throw new CalcException(
                    String.format("Невозможно обработать %s%s%s", left, op, rigth)
            );
        }
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
                String.format("Неизвестная ошибка")
        );
    }

    Var calc(String expression) throws CalcException {

        Pattern pattern = Pattern.compile(Patterns.SCOBCI);
        Matcher match = pattern.matcher(expression);
        while (match.find()) {
            String sb = match.group();
            String sbNew = sb.replace("(", "").replace(")", "");
            expression = expression.replace(sb, calc(sbNew).toString());
            match = pattern.matcher(expression);
        }

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
            String rigth = operands.get(num);
//            debug();
            res = oneOperation(left, op, rigth);
            operands.set(num, res.toString());
        }
        return res;
    }
}
