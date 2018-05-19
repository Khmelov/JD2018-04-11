package by.it.zaliashchonak.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
//    Var calc(String expression){
//        // два + три
//        expression=expression.trim().replaceAll("\\s+","");
//        String[] operands = expression.split(Patterns.OPERATION);
//        Var one=Var.createVar(operands[0]);
//        Var two=Var.createVar(operands[1]);
//        if (one==null || two==null)
//            return null; //todo Create error
//        Pattern pattern=Pattern.compile(Patterns.OPERATION);
//        Matcher matcher = pattern.matcher(expression);
//        if (matcher.find()){
//            String operation=matcher.group();
//            switch (operation) {
//                case "+": return one.add(two);
//                case "-": return one.sub(two);
//                case "*": return one.mul(two);
//                case "/": return one.div(two);
//            }
//        }
//        return one; //todo Create error
//    }

    Var calc(String expression){

        Pattern p=Pattern.compile (Patterns.OPERATION);
        Matcher m=p.matcher(expression);
        if (m.find()) {
            String[] strOp=expression.split(Patterns.OPERATION);
            Var one= Var.createVar(strOp[0]);
            Var two=Var.createVar(strOp[1]);
            String operation=m.group();
            switch (operation){
                case "+":return one.add(two);
                case "-":return one.sub(two);
                case "*":return one.mul(two);
                case "/":return one.div(two);
            }
        }
        return null;
    }


}
