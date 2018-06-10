package by.it.kashayed.jd02_04.jd02_04new;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private List<String> operands;
    private List<String> operations;
    private static Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private int getNumOp() {
        int pos = -1;
        int lvl = -1;
        for (int i = 0; i < operations.size(); i++) {
            String getOp = operations.get(i);
            if (lvl < priority.get(getOp)) {
                lvl = priority.get(getOp);
                pos = i;
            }
        }
        return pos;
    }

    private Var oneOp(String left, String op, String right) throws CalcException {
        Var second = Var.createVar(right);
        if (op.equals("=")) {
            return Var.numbers(left, second);
        }
        Var first = Var.createVar(left);
        if (first == null || second == null) {
            throw new CalcException();
        }
        switch (op){
            case"+":return first.add(second);
            case"-":return first.sub(second);
            case"*":return first.mul(second);
            case"/":return first.div(second);
        }
        throw new CalcException("что-то пошло не так");
    }


    Var calc(String expression) throws CalcException {
        operands=new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        operations=new ArrayList<>();
        while(matcher.find()){
            operations.add(matcher.group());
        }
        Var res = Var.createVar(expression);
        while(operations.size()>0){
            int num = getNumOp();
            String left = operands.remove(num);
            String right = operands.get(num);
            String op = operations.remove(num);
            res = oneOp(left,op,right);
            operands.set(num,res.toString());
        }

      return res;
    }

}
