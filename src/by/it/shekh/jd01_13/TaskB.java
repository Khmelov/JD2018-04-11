package by.it.shekh.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double num = 0.0, sum = 0.0, sqr = 0.0;
        String str;
        while (true) {
            str = sc.nextLine();
            try {
                if (str.equals("END"))
                    break;
                num = Double.parseDouble(str);
                if (num < 0) throw new ArithmeticException();
                sum += num;
                sqr = Math.sqrt(sum);
                System.out.println(num + " " + sqr);
            } catch (NumberFormatException | ArithmeticException e) {
                String name = e.getClass().getName();
                String strClasz = e.getClass().getName();
                int line = 0;
                StackTraceElement[] stackTrace = e.getStackTrace();
                Class<TaskB> clasz = TaskB.class;
                for (int i = 0; i < stackTrace.length; i++) {

                    StackTraceElement element = stackTrace[i];
                    if (clasz.getName().equals(element.getClassName())) {
                        strClasz = element.getClassName();
                        line = element.getLineNumber();
                    }

                }
                System.out.printf(" name: %s\n" + "class: %s\n" + " line: %d", name, strClasz, line);
            }
        }
    }
}
