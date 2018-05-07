package by.it.rogov.jd01_02;


import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] mas = new int[n][n];

        step1(n);

        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        step2(m4);

        step3(m4);
    }


    private static int[][] step1(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        boolean flag1 = false;
        boolean flag2 = false;
        while (!(flag1 && flag2)) {
            flag1 = false;
            flag2 = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(n * 2 + 1) - n;
                    if (matrix[i][j] == n) flag1 = true;
                    if (matrix[i][j] == -n) flag2 = true;
                }

            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.printf("%3d ", matrix[i][j]);
                if (j == n - 1) System.out.println();
            }
        }
        return matrix;
    }

    private static int step2(int[][] mas) {

        int sum = 0;
        int sum1 = 0;
        boolean firstelement;


        for (int i = 0; i < mas.length; i++) {
            firstelement = false;
            for (int j = 0; j < mas.length; j++) {

                if (firstelement && mas[i][j] >= 0) {
                    break;

                } else if (firstelement) {
                    sum1 = sum1 + mas[i][j];

                } else if (mas[i][j] >= 0) {
                    firstelement = true;
                } else {
                    sum1 = 0;
                }
            }
            sum = sum + sum1;
        }
        return sum;
    }

    private static int[][] step3(int[][] mas) {

        int max = mas[0][0];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (max < mas[i][j]) max = mas[i][j];
            }

        }
        boolean[] arrayi = new boolean[mas.length];
        boolean[] arrayj = new boolean[mas.length];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {

                if (max == mas[i][j]) {
                    arrayi[i] = true;
                    arrayj[j] = true;
                }

            }

        }
        int arraylenghti = 0;
        for (boolean b : arrayi) {
            if (b == false) arraylenghti += 1;

        }
        int arraylenghtj = 0;
        for (boolean b : arrayj) {
            if (b == false) arraylenghtj += 1;

        }


        int[][] result = new int[arraylenghti][arraylenghtj];
        int i1 = 0;
        int j1 = 0;

        for (int i = 0; i < mas.length; i++) {

            for (int j = 0; j < mas.length; j++) {

                if (!arrayi[i]) {

                    if (!arrayj[j]) {
                        result[i1][j1] = mas[i][j];
                        j1++;

                    }

                }
                if (!arrayi[i] && j1 == arrayj.length - 1) {
                    i1++;
                    j1 = 0;
                }
            }

        }
        return result;
    }


}



