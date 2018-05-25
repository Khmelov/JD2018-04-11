package by.it.zakharenko.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        double sum = 0.0;
        while (!(str = scanner.next()).equals("END")) {
            try {
                double number = Double.parseDouble(str);
                sum += number;
                if (sum >= 0)
                    System.out.println("The root of the sum is: " + Math.sqrt(sum));
                else
                    throw new ArithmeticException();
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (int i = 0; i < stackTrace.length; i++) {
                    StackTraceElement element = stackTrace[i];
                    String name = e.getClass().getName();
                    String strClass = element.getClassName();
                    int number = element.getLineNumber();
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.printf(" name: %s\nclass: %s\n line: %d\n", name, strClass, number);
                        break;
                    }
                }
            }
        }
    }
}
