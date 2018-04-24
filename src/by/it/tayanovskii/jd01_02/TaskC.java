package by.it.tayanovskii.jd01_02;

import by.it.tayanovskii.jd01_03.InOut;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int matr[][] = new int[n][n];
        matr = step1(n);
        step2(matr);
        int [] [] result  = new int [step3(matr).length][step3(matr)[0].length];
        result=step3(matr);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {

                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }



    }

    private static int[][] step1(int n) {
        int matrix[][] = new int[n][n];

        Random random = new Random();
        boolean flag_n_1 = true;
        boolean flag_n_2 = true;
        do {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = (random.nextInt(2 * n + 1) - n);
                    if (matrix[i][j] == n) {
                        flag_n_1 = false;
                    }
                    if (matrix[i][j] == -n) {
                        flag_n_2 = false;
                    }
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

        }
        while (flag_n_1 || flag_n_2);
        return matrix;

    }

    private static int step2(int[][] mas) {
        int sum = 0;

        for (int i = 0; i < mas.length; i++) {
            int start = -1;
            int end = -1;
            int l_Sum = 0;
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] > 0) {
                    start = j;
                    break;
                }

            }
            for (int j = (start + 1); j < mas[0].length; j++) {
                if (mas[i][j] > 0) {
                    end = j;
                    break;
                }

            }

            if (start != -1 && end != -1 && end > start) {
                for (int j = (start + 1); j < end; j++) {
                    l_Sum += mas[i][j];
                }
            }
            //else
            //System.out.println("нет положительных элементов");

            sum += l_Sum;
        }
        System.out.println(sum);
        return sum;

    }

    static int[][] step3(int[][] mas) {

//        Найти максимальный элемент(ы) в матрице и удалить из исходной
//        матрицы все строки и столбцы, его содержащие. Вывести в консоль и
//        вернуть полученную матрицу. Сигнатура int[ ][ ] step3(int[ ][ ] mas)

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j]>max) {
                    max = mas[i][j];
                }

            }

        }
        //System.out.println(max);

        boolean[] delCol = new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }

            }

        }
        int rr = 0;
        int cc = 0;
        for (boolean b : delRow) if (!b) rr++;
        for (boolean b : delCol) if (!b) cc++;
        int[][] m = new int[rr][cc];

        int ii = 0;
        for (int i = 0; i < mas.length; i++) {
            int jj = 0;
            for (int j = 0; j < mas[i].length; j++) {
                if (!delCol[j] && !delRow[i]) {
                    m[ii][jj++] = mas[i][j];
                }

            }
            if (!delRow[i]) ii++;

        }

        return m;

    }
}


