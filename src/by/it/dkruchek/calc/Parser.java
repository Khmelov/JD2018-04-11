package by.it.dkruchek.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dmitriy.Kruchek on 5/7/2018.
 */
public class Parser {
    Var calc(String exp) throws CalcException{
        exp = exp.trim().replaceAll("\\s+", "");
        String[] operands = exp.split(Patterns.OPERATION);
        Var two = Var.createVar(operands[1]);
        if (exp.contains("=")){
            return Var.saveVar(operands[0],two);
        }
        Var one = Var.createVar(operands[0]);
        if (one == null || two == null){
            throw new CalcException("One of the operands in NULL");
        }
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(exp);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null; //TODO Create error
    }
}
