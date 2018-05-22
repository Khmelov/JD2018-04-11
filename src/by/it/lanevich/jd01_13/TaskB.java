package by.it.lanevich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        double sq, s = 0, list;
        while (!(str = scanner.nextLine()).equals("END")) {
            try {
                list = Double.parseDouble(str);
                s += list;
                if (s < 0)
                    throw new ArithmeticException();
                sq = Math.sqrt(s);
                System.out.println(list+ " " + sq);
            } catch ( ArithmeticException|NumberFormatException e) {

                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String clName = element.getClassName();
                        int number = element.getLineNumber();
                        System.out.printf(
                                " name: %s\n" +
                                        "class: %s\n" +
                                        " line: %d\n",
                                name, clName, number);
                        break;
                    }
                }
            }
        }

    }
}
