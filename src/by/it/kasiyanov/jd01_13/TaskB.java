package by.it.kasiyanov.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        double number, sqr;
        double sum = 0;

        while (!((line = scan.next()).equals("END"))){
            try {
                number = Double.parseDouble(line);
                sum += number;
                sqr = Math.sqrt(sum);
                if (sum < 0){
                    throw new ArithmeticException();
                }
                System.out.println("number = " + number);
                System.out.println("sqrt = " + sqr);
            }
            catch (Exception e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String clname = element.getClassName();
                        int lineNumber = element.getLineNumber();
                        System.out.printf(
                                " name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n",
                                name, clname, lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
