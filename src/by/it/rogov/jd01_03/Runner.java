package by.it.rogov.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);

        System.out.println(" Simple format output");
        InOut.printArray(array);

        System.out.println("Format output ");
        InOut.printArray(array, "v", 3);

        System.out.println("Max=" + Helper.findMax(array));

        System.out.println("Min=" + Helper.findMin(array));

        System.out.println("Sort array maximum");
        Helper.sort(array);

        System.out.println("Input vector");
        double[] vector = InOut.getArray(line);

    }
}

