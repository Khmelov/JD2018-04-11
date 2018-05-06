package by.it.kasiyanov.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        System.out.println("Simple format output:");
        InOut.printArray(array);
        System.out.println();
        System.out.println("Formatted output:");
        InOut.printArray(array, "V", 3);
        System.out.println("Sorted output:");
        Helper.sort(array);
        InOut.printArray(array);
        System.out.println();
        System.out.println("Minimum value:" + Helper.findMin(array));
        System.out.println("Maximum value:" + Helper.findMax(array));

        double matrix[][] = new double[3][3];
        double vector[] = new double[3];
        double resMV[];
        double resMM[][];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * (2 * 10 + 1)) - 10;
            }
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int)(Math.random() * (2 * 10 + 1)) - 10;
        }

        resMV = Helper.mul(matrix, vector);

        for (int i = 0; i < resMV.length; i++) {
            System.out.print(resMV[i] + " ");
        }
        // System.out.println(Arrays.toString(resMV));
        System.out.println();

        resMM = Helper.mul(matrix, matrix);

        for (int i = 0; i < resMM.length; i++) {
            for (int j = 0; j < resMM[i].length; j++) {
                System.out.print(resMM[i][j] + " ");
            }
            System.out.println();
        }
    }
}
