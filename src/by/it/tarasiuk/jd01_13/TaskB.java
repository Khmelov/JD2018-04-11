package by.it.tarasiuk.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        double sum = 0;
        while (!(line = scanner.next()).equals("END")) {
            try {
                double aDouble = Double.parseDouble(line);
                System.out.println(aDouble);
                sum += aDouble;
                if (sum >= 0)
                    System.out.println("sum = " + sum + "\nsqrt sum = " + Math.sqrt(sum));
                else
                    throw new ArithmeticException();
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int number = element.getLineNumber();
                        System.out.printf(
                                "name: %s\n" +
                                        "class: %s\n" +
                                        "line: %d\n",
                                name, className, number);
                        break;
                    }
                }
            }

        }
    }
}
