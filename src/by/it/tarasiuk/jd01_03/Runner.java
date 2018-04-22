package by.it.tarasiuk.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);

        System.out.println("Simple format output: ");
        InOut.printArray(array);

        System.out.println("Formatted output: ");
        InOut.printArray(array, "V", 3);

        System.out.println("Minimum of array: " + Helper.findMin(array));

        System.out.println("Maximum of array: " + Helper.findMax(array));

        System.out.println("Sorted array: ");
        InOut.printArray(Helper.sort(array));
    }
}
