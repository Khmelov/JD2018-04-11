package by.it.rogov.jd01_13;


import java.util.LinkedList;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        LinkedList<Double> nubbers = new LinkedList<>();
        int index = 1;

        while (!(s = scanner.next()).equals("end")) {
            try {

                nubbers.addLast(Double.parseDouble(s));
                index++;
                Double x = 0.0;
                for (Double aDouble : nubbers) {
                    x = x + aDouble;
                    if (x < 0)
                        throw new ArithmeticException();

                }

                System.out.printf("number: %s\n sqrt: %s\n ", nubbers.getLast(), Math.sqrt(x));

            } catch (NumberFormatException | ArithmeticException e) {

                String name = e.getClass().getName();

                System.out.println("name: "+ name);

                StackTraceElement[] stackTrace = e.getStackTrace();

                for (StackTraceElement element : stackTrace) {

                    if (TaskB.class.getName().equals(element.getClassName())) {

                        System.out.println("class: " + element.getClassName() + "\n" + "line: " + element.getLineNumber());

                        break;
                    }
                }
            }

        }

    }
}
