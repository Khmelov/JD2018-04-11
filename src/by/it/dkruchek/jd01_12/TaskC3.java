package by.it.dkruchek.jd01_12;

import java.util.*;

/**
 * Created by Dmitriy.Kruchek on 5/17/2018.
 */
public class TaskC3 {
    static boolean checkBrackets(String stringToTest) {
        boolean isOK = false;
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < stringToTest.length(); i++) {
            String str = "" + stringToTest.charAt(i);
            //if opening bracket push into stack
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.push(str);
            }
            if(str.equals(")") || str.equals("]") || str.equals("}")){
                //if closing bracket and stack's empty return false
                if(stack.isEmpty()){
                    return false;
                }
                String opening = stack.peek();
                if(str.equals(")") && opening.equals("(")){
                    stack.pop();
                }
                if(str.equals("]") && opening.equals("[")){
                    stack.pop();
                }
                if(str.equals("}") && opening.equals("{")){
                    stack.pop();
                }
            }
        }
        if(stringToTest.length() > 0 && stack.isEmpty()){
            isOK = true;
        }
        return isOK;
    }

    public static void main(String[] args) {
        String[] inputs = {"{[()]}","{[(])}","{{[[(())]]}}"};
        for(String input : inputs){
                System.out.println(checkBrackets(input));
        }
    }
}
