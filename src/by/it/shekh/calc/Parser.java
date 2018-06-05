package by.it.shekh.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static Map<String, Integer> priorMap = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("-", 1);
            this.put("+", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };


    private List<String> operations;
    private List<String> operands;

    private int getNumberOp() {
        int position = -1;
        int priorLevel = 1;

        for (int i = 0; i < operations.size(); i++) {
            String currentOp = operations.get(i);
            if (priorLevel < priorMap.get(currentOp)) {
                priorLevel = priorMap.get(currentOp);
                position = i;
            }
        }
        return position;
    }


//    private void debug(){
//        System.out.println(operands.get(0));
//        for (int i = 0; i <operations.size() ; i++) {
//            System.out.println(operations.get(i)+operands.get(i+1));
//        }
//        System.out.println();
//    }

    Var calc(String expression) throws CalcException {
        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION)));
        Pattern patternOp = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOp.matcher(expression);
        operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        Var res = null;
        while (operations.size() > 0) {
            int numOps = getNumberOp();
            String left = operands.remove(numOps);
            String operation = operations.remove(numOps);
            String right = operands.get(numOps);
            //debug();
            res = oneOperation(left, operation, right);
            operands.set(numOps, res.toString());
        }
        return res;
    }


    private Var oneOperation(String left, String operation, String right) throws CalcException {

        Var two = Var.createVar(right);
        if (operation.equals("=")) {
            return Var.saveVar(left, two);
        }
        Var one = Var.createVar(left);
        if (one == null || two == null)
            throw new CalcException(String.format("Невозможно обработать %s%s%s", left, operation, right)); //todo Create error
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

        throw new CalcException(String.format("Невозможно обработать %s%s%s", left, operation, right)); //todo Create error

    }

}
