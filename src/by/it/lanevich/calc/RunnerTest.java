package by.it.lanevich.calc;

import java.util.*;

public class RunnerTest {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String line;

        Parser parser=new Parser();
        Map<String, Var> hashVar = new HashMap<String, Var>();
        while(!(line=scan.nextLine()).equals("end")){
            if(line.equals("printvar"))
            {
                for(Map.Entry<String, Var> item :hashVar.entrySet()){
                    System.out.printf("%s=%s \n", item.getKey(), item.getValue());
                     }break;
            }
            String[] operand = line.split("=");
            hashVar.put(operand[0], Var.createVar(operand[1]));
            }
        }
}


