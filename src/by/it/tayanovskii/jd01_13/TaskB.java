package by.it.tayanovskii.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        double sum = 0, sqr = 0, num;
        while (!(str = scanner.next()).equals("END")) {
            try {
                num = Double.parseDouble(str);
                sum += num;
                if (sum < 0)
                    throw new ArithmeticException();
                sqr = Math.sqrt(sum);
                System.out.println(num + " " + sqr);

            } catch (NumberFormatException | ArithmeticException e) {
                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                Class<TaskB> clazz = TaskB.class; //наш текущий класс
                for (int i = 0; i < stackTrace.length; i++) {
                    StackTraceElement element = stackTrace[i];
                    if (clazz.getName().equals(element.getClassName())) {
                        String strClass = element.getClassName();
                        System.out.printf(" name: %s\nclass: %s\n line: %d\n", name, strClass, element.getLineNumber());
                        break;
                    }
                }
            }
        }
        System.out.println("end");
    }
}
