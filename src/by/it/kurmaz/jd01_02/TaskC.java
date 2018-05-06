package by.it.kurmaz.jd01_02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Enter matrix size");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas =  step1(n);
        step2(mas);
        step3(mas);
    }

    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        for (int[] ma : mas) {
            for (int aMa : ma) {
                if (aMa > max)
                    max = aMa;
            }
        }

        //System.out.println(max);

        ArrayList<Coordinates> coordinates = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length ; j++) {
                if (mas[i][j] == max)
                    coordinates.add(new Coordinates(i, j));
            }
        }
        Coordinates[] coordinates1 = new Coordinates[coordinates.size()];
        coordinates.toArray(coordinates1);

        ArrayList<Integer[]> matrix = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            boolean foundMax = false;
            for (Coordinates c: coordinates1) {
                if (c.row == i) {
                    foundMax = true;
                    break;
                }
            }
            if (foundMax)
                continue;
            for (int j = 0; j < mas[i].length; j++) {
                boolean foundMax1 = false;
                for (Coordinates c: coordinates1) {
                    if (c.column == j) {
                        foundMax1 = true;
                        break;
                    }
                }
                if (!foundMax1)
                    row.add(mas[i][j]);
            }
            if (row.size() > 0) {
                Integer[] newRow = new Integer[row.size()];
                row.toArray(newRow);
                matrix.add(newRow);
            }
        }

        int[][] newMatrix = new int[matrix.size()][matrix.get(0).length];
        for (int i = 0; i < matrix.size(); i++) {
            Integer[] row = matrix.get(i);
            for (int j = 0; j < row.length ; j++) {
                newMatrix[i][j] = row[j];
            }
        }

        for (int[] aNewMatrix : newMatrix) {
            for (int j = 0; j < newMatrix.length; j++) {
                System.out.print(aNewMatrix[j] + " ");
            }
            System.out.println("\n");
        }
        return newMatrix;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int[] ma : mas) {
            int positiveCounter = 0;
            int rowSum = 0;
            for (int j = 0; j < ma.length; j++) {
                if (ma[j] > 0)
                    positiveCounter++;
                if ((positiveCounter == 1) && (j < (ma.length - 1)) && (ma[j + 1] < 0))
                    rowSum += ma[j + 1];
            }
            if (positiveCounter >= 2)
                sum += rowSum;
            //System.out.println(sum);
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step1(int n) {
        int [][] mas = new int[n][n];
        int positive;
        int negative;
        Random random = new Random();
        do {
            positive = 0;
            negative = 0;
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < n; j++) {
                    boolean isNegative = random.nextBoolean();
                    int number;
                    if (isNegative)
                        number = random.nextInt(n) + 1;
                    else
                        number = - (random.nextInt(n) + 1);
                    mas[i][j] = number;
                    if (number == n)
                        positive = 1;
                    if (number == (-n))
                        negative = -1;
                }
            }
        }
        while ((positive == 0) || (negative == 0));

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println("\n");
        }
        return mas;
    }
}


