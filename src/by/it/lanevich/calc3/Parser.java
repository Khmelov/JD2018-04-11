package by.it.lanevich.calc3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static by.it.lanevich.calc3.ConsoleRunner.rm;


public class Parser {
    List<String> priority =
            new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));

    List<String> operations;
    List<String> operands;

    private int getNumOperation() {
        // = + + * / - -
        int curnum = -1;
        int prior = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int p = priority.indexOf(op);
            if (p > prior) {
                curnum = i;
                prior = p;
            }
        }
        return curnum;
    }


public Var calc(String expression) throws CalcException {
    Deque<String> dequeExpr = new ArrayDeque<>();
    String curExp;
    String s;

    for (int i = 0; i < expression.length(); i++) {

       char c = expression.charAt(i);
       if(c==')')
            { curExp="";
            s=dequeExpr.pollLast();
            while (!s.equals("(")) {
                curExp = s + curExp;
                s = dequeExpr.pollLast();
            }
            Var calcul = calc_exp(curExp);
            dequeExpr.add(calcul.toString());
        }
       else
            dequeExpr.add(String.valueOf(c));
        }

        expression = "";
        for (String q : dequeExpr) {
            expression += q;
        }
        return calc_exp(expression);

}

    Var calc_exp(String expression) throws CalcException {
        operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        operations = new ArrayList<>();

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
        }
        while (operations.size() > 0) {
            int index = getNumOperation();
            String op = operations.remove(index);
            String oLeft = operands.get(index);
            String oRight = operands.remove(index + 1);
            operands.set(index, calcOneOperation(oLeft, op, oRight).toString());
        }
     return Var.createVar(operands.get(0));
    }

    private Var calcOneOperation(String strVarLeft, String operation, String strVarRight) throws CalcException {
        Var two = Var.createVar(strVarRight);
        if (operation.equals("=") && strVarLeft.matches(Patterns.VARNAME))
            return Var.saveVar(strVarLeft, two);
        Var one = Var.createVar(strVarLeft);
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
        throw new CalcException(rm.getString(Messages.NOSUCHOPERATION));
    }
    }


