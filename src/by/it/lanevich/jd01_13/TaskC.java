package by.it.lanevich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;

    static void readData() throws InterruptedException {
        String str;
        int c = 0;
        List<Double> list = new ArrayList<>();
        while (!(str = scanner.nextLine()).equals("END")) {
            try {
                list.add(Double.parseDouble(str));

            } catch (NumberFormatException e) {
                if (++c == 5) throw e;
                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        scanner = new Scanner(System.in);
        readData();
    }

}
