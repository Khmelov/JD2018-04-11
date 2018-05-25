package by.it.shumilov.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line;
        Double res = 0.0;
        while (!(line=sc.next()).equals("END")){
            try{
            Double num = Double.parseDouble(line);
            if (num<0) throw new ArithmeticException("Корень из отрицательного числа!");
            res += num;
            //res = Math.sqrt(res);

            System.out.println(Math.sqrt(res));
            }
            catch (ArithmeticException | NumberFormatException e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                Class<TaskB> clazz = TaskB.class;  //out class
                for (int i = 0; i < stackTrace.length; i++) {
                    if (clazz.getName().equals(stackTrace[i].getClassName())) {
                        System.out.printf(" name: %s\nclass: %s\n line: %s\n", e.getClass().getName(), stackTrace[i].getClassName(), stackTrace[i].getLineNumber());
                        break;
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getClass().getName());
            }

        }



    }
}
