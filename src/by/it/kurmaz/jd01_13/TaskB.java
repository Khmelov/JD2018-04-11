package by.it.kurmaz.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        String line;
        double sum = 0;
        while (!(line = scanner.nextLine()).equals("END")) {
            try {
                double number = Double.parseDouble(line);
                sum += number;
                if (sum >= 0)
                    System.out.println("Square root of sum: " + Math.sqrt(sum));
                else
                    throw new ArithmeticException();
            }
            catch (NumberFormatException| ArithmeticException e) {
                System.out.println("name: " + e);
                StackTraceElement[] elements = e.getStackTrace();
                for (StackTraceElement element: elements) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.println("class: " + element.getClassName());
                        System.out.println("line: " + element.getLineNumber());
                    }
                }
            }
        }
    }
}
