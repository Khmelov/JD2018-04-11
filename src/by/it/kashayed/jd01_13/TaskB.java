package by.it.kashayed.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double number=0;
        double sum = 0;
        double sqrt=0;
        String s;
        try{
        while (!(s=scanner.next()).equals("END")){
            number=Double.parseDouble(s);
            sum+=number;
            if (sum<0){
                throw new ArithmeticException();
            }
            sqrt =Math.sqrt(sum);
            System.out.println("String = "+s);
            System.out.println("number = "+ number);
            System.out.println("sqrt = "+ sqrt);
            System.out.println("sum = "+ sum);
            }
        }

        catch (NumberFormatException error){
            StackTraceElement[] stackTrace = error.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                //System.out.println(element);
                if(TaskB.class.getName().equals(element.getClassName())){
                    //  System.out.println(element);
                    System.out.println(" name: "+ error.getClass().getName());
                    System.out.println("class: "+ element.getClassName());
                    System.out.println(" line: "+ element.getLineNumber());
                }
            }
        }
       catch (ArithmeticException error){
            StackTraceElement[] stackTrace = error.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                //System.out.println(element);
                if(TaskB.class.getName().equals(element.getClassName())){
                    //  System.out.println(element);
                    System.out.println(" name: "+ error.getClass().getName());
                    System.out.println("class: "+ element.getClassName());
                    System.out.println(" line: "+ element.getLineNumber());

                }
            }
        }
    }
}

//        double sum=0;
//        double i=0;
//        try {
//            String str = scanner.next();
//            while (!str.equals("END")) {
//                if (!str.equals("END")) {
//                    str = scanner.next();
//                    i = Double.parseDouble(str);
//                    System.out.println(i);
//                    System.out.println(Math.sqrt(sum));
//                }
//            }
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }