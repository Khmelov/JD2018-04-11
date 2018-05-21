package by.it.kurmaz.jd01_13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter a number");
        readData();
    }

    private static void readData() throws InterruptedException {
        int counter = 0;
        LinkedList<Double> list = new LinkedList<>();
        String line;
        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equals("END")) {
            try {
                double number = Double.parseDouble(line);
                list.add(number);
            } catch (NumberFormatException e) {
                counter++;
                Iterator iterator = list.descendingIterator();
                Thread.sleep(100);
                while (iterator.hasNext())
                    System.out.print(iterator.next() + " ");
                System.out.println();
                if (counter == 5)
                    throw e;
            }
        }
    }
}
