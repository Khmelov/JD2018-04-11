package by.it.dkruchek.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
public class Parser {

    private static ResMan rm = ResMan.getInstance();

    private static Map<String, Integer> priorityMap = new HashMap<String, Integer>()
    {{

        this.put("=", 0);
        this.put("+", 1);
        this.put("-", 1);
        this.put("*", 2);
        this.put("/", 2);

    }};

    private List<String> operations;
    private List<String> operands;

    private int getNumberOp() {
        int pos = -1;
        int level = -1;
        for (int i = 0; i < operations.size(); i++) {
            String currerntOp = operations.get(i);
            if (level < priorityMap.get(currerntOp)){
                level = priorityMap.get(currerntOp);
                pos = i;
            }
        }
        return pos;
    }

    Var calc(String expression) throws CalcException {
        // find, calculate and replace expressions in parentheses recursively
        Pattern exp = Pattern.compile(Patterns.PARENTHESES_EXPRESSION);
        Matcher m = exp.matcher(expression);
        while (m.find()){
            String group = m.group(1).replaceAll("\\(|\\)", "");
            expression = expression.replaceFirst(Patterns.PARENTHESES_EXPRESSION, calc(group).toString());
            m.reset(expression);
        }

        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION)));
        Pattern patternOp = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOp.matcher(expression);
        operations = new ArrayList<>();
        while (matcher.find()){
            operations.add(matcher.group());
        }
        Var result = null;
        while (operations.size() > 0){
            int number = getNumberOp();
            String left = operands.remove(number);
            String op = operations.remove(number);
            String right = operands.get(number);
            //debug();
            result = oneOperation(left, op, right);
            operands.set(number, result.toString());
        }
        return result;
    }

    private void debug(){
        System.out.println(operands.get(0));
        for (int i = 0; i < operations.size(); i++) {
            System.out.println(operations.get(i) + operands.get(i+1));
        }
        System.out.println();
    }

    private Var oneOperation(String left, String op, String right) throws CalcException{

        Var two = Var.createVar(right);
        if (op.contains("=")){
            return Var.saveVar(left,two);
        }
        Var one = Var.createVar(left);
        if (one == null || two == null){
            throw new CalcException(rm.getString(ParserError.EMPTY));
        }

        switch (op){
            case "+": return one.add(two);
            case "-": return one.sub(two);
            case "*": return one.mul(two);
            case "/": return one.div(two);
        }

        throw new CalcException(rm.getString(ParserError.UNKNOWN));    }


}
