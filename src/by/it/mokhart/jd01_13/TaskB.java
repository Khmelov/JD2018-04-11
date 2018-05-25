package by.it.mokhart.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        double sum = 0.00;
        double sqrt;
        while (!(input = sc.next()).equals("END")) {
            try {
                double n = Double.parseDouble(input);
                sum = sum + n;
                sqrt = Math.sqrt(sum);
                if (sum > 0)
                    System.out.println("Sqrt of sum = " + sqrt);
                else throw new ArithmeticException();
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.println(element);
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int lineNumber = element.getLineNumber();
                        System.out.printf("name: %s\n" + "class: %s\n" + "line: %s\n", name, className, lineNumber);
                        break;
                    }
                }
            }
        }
    }
}

