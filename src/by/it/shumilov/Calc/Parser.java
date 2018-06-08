package by.it.shumilov.Calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private GetStr getStr = GetStr.getInstance();

    private static Map<String,Integer> priorityMap = new HashMap<String, Integer>(){
        {

            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };


    private List<String> operations;
    private List<String> operands;

    private void debag(){
        System.out.print(operands.get(0));
        for (int i = 0; i < operations.size(); i++) {
            System.out.print(operations.get(i ) + operands.get(i +1));
        }
        System.out.println();
    }

    private int getNumOp(){
        int pos = -1;
        int level = -1;
        for (int i = 0; i < operations.size(); i++) {
            String currentOp = operations.get(i);
            if(level<priorityMap.get(currentOp)){
                level = priorityMap.get(currentOp);
                pos = i;
            }

        }
        return  pos;
    }

    private String getBrackets(String line) throws CalcException {


        Pattern patternBr = Pattern.compile(Patterns.BRACKETS);
        Matcher maBrackets = patternBr.matcher(line);
        int i = line.indexOf("(");
        if(i > 0)
            i=1;

        if (maBrackets.find()){
            List<String> operands = new ArrayList<>(Arrays.asList(line.split(Patterns.BRACKETS)));
            do {
                String br  = maBrackets.group();
                //System.out.println(br.substring(1,br.length()-1));
                operands.add(i,this.calc(br.substring(1,br.length()-1)).toString());
                i += 2;
            }while (maBrackets.find());

            return getBrackets(operands.stream().reduce((s1,s2)->s1+s2).orElse(getStr.getString(Err.ERROR)));

        }

        return line;
    }

    Var calc(String expression) throws CalcException {

        expression = getBrackets(expression);

        operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));//////////////////
        Pattern patternOp = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = patternOp.matcher(expression);
        operations = new ArrayList<>();
        while (matcher.find()){
            operations.add(matcher.group());
        }


        Var res = Var.createVar(expression);

        while (operations.size() > 0){
            int num = getNumOp();
            debag();
            String left = operands.remove(num);
            String op = operations.remove(num);
            String right = operands.get(num);


            res = oneOperation(left,op,right);


            operands.set(num,res.toString());
        }
        return  res;
    }

    private Var oneOperation(String left, String op, String right) throws CalcException {
        Var two = Var.createVar(right);
        if(op.equals("="))
            return Var.saveVar(left,two);

        Var one = Var.createVar(left);
        if (one == null || two==null)
            throw  new  CalcException(
                    String.format("%s %s%s%s",getStr.getString(Err.UNPROC),left, op, right)
            );
                switch (op){
                    case "+": return  one.add(two);
                    case "-": return  one.sub(two);
                    case "*": return  one.mul(two);
                    case "/": return  one.div(two);
                }

        throw new CalcException(
                String.format("%s %s%s%s",getStr.getString(Err.UNERROR),left, op, right)
        );
    }


}
