package by.it.kurmaz.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line to form an array");
        double[] array = InOut.getArray(scanner.nextLine());

        System.out.println("Array looks like:");
        InOut.printArray(array);

        System.out.println("Give a name for an array");
        String name = scanner.nextLine();

        System.out.println("How many columns to print?");
        int columnCount = scanner.nextInt();
        InOut.printArray(array, name, columnCount);

        double min = Helper.findMin(array);
        System.out.println("Minimal value of the array is: " + min);

        double max = Helper.findMax(array);
        System.out.println("Maximal value of the array is: " + max);

        System.out.println("Sorted array looks like:");
        Helper.sort(array);

        System.out.println("Let`s make a simple matrix. How many columns?");
        int columns = scanner.nextInt();
        System.out.println("And how many rows?");
        int rows = scanner.nextInt();
        String buffer = scanner.nextLine();
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter a row # " + i);
            matrix[i] = InOut.getArray(scanner.nextLine());
        }

        System.out.println("Now we have a matrix. Lets make a vector. Enter a line for a vector");
        String vectorLine = scanner.nextLine();
        double[] vector = InOut.getArray(vectorLine);

        System.out.println("Multiply a matrix to a vector gives a result:");
        double[] newVector = Helper.mul(matrix, vector);
        InOut.printArray(newVector);

        System.out.println("Lets make a second matrix of the same size");
        double[][] newMatrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter a row # " + i);
            newMatrix[i] = InOut.getArray(scanner.nextLine());
        }

        System.out.println("Multiply matrix 1 to matrix 2 gives a result:");
        double[][] matrix3 = Helper.mul(matrix, newMatrix);
        InOut.printMatrix(matrix3, columns);
    }
}
