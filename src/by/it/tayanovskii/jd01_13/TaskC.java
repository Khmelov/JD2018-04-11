package by.it.tayanovskii.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static Scanner scanner;

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }


    static void readData() throws InterruptedException {
        String str;
        int counter = 0;
        List<Double> numbers = new ArrayList<>();
        while (!(str = scanner.next()).equals("END")) {
            try {
                numbers.add(Double.parseDouble(str));
            } catch (NumberFormatException e) {
                if (counter == 5)
                    throw e;
                Thread.sleep(100);

                for (int i = numbers.size() - 1; i >= 0; i--) {
                    System.out.print(numbers.get(i) + " ");
                }
                System.out.println();
                counter++;
            }
        }
    }

}