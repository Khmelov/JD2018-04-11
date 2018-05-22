package by.it.dkruchek.jd01_13;

import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 5/19/2018.
 */
public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        double sum = 0;
        while (!(s = sc.next()).equals("END")){
            try{
                double d = Double.parseDouble(s);
                System.out.println(d);
                sum += d;
            }
            catch (NumberFormatException e){
                System.out.println("class: " + e.getClass());
                System.out.println("package: " + TaskB.class.getName());
                System.out.println("line: " + e.getStackTrace()[0].getLineNumber());
            }
            try{
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)){
                    throw new ArithmeticException();
                }
                else{
                    System.out.println(sqrt);
                }
            }
            catch (ArithmeticException e){
                System.out.println("class: " + e.getClass());
                System.out.println("package: " + TaskB.class.getName());
                System.out.println("line: " + e.getStackTrace()[0].getLineNumber());
            }
        }
    }
}
