package by.it.shekh.jd01_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    static Scanner sc;
    static ArrayList<Double> arr = new ArrayList<>();
    static int errCount = 0;

    static void readData() throws InterruptedException {
        try {
            arr.add(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            errCount++;
            if (errCount > 5) throw new NumberFormatException();
            Thread.sleep(100);
            System.out.println("ERROR #:" + errCount);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(arr.size() - i - 1) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException, NumberFormatException {
        sc = new Scanner(System.in);

        while (true) {
            readData();
        }
    }
}
