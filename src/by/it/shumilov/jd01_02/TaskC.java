package by.it.shumilov.jd01_02;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.valueOf(mas[i][j]) + " ");
            }
            System.out.println();
        }
        int sum = step2(mas);
        System.out.print(String.valueOf(sum));
        int[][] mas1 = step3(mas);
    }

    private static int[][] step1(int n) {
        boolean min = false;
        boolean max = false;
        int[][] mass = new int[n][n];
        Random mRandom = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mass[i][j] = mRandom.nextInt(2 * n + 1) - n;
                if (mass[i][j] == -n) min = true;
                if (mass[i][j] == n) max = true;
            }
        }
        if (min && max) return mass;
        else return step1(n);
    }

    private static int step2(int[][] mas) {
        boolean start = false;
        boolean finish = false;
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (!start && mas[i][j] > 0) {
                    start = true;
                    continue;
                } else if (start && mas[i][j] > 0) {
                    start = false;
                    break;
                } else if (start) {
                    sum += mas[i][j];
                }
            }
            //if (finish) break;
        }
        return sum;
    }

    private static int[][] step3(int[][] mas) {

        System.out.println();
        System.out.println();
        int jampcow = 0;
        int jampcolumn ;
        HashSet<Integer> columns = new HashSet<Integer>();
        HashSet<Integer> rows = new HashSet<Integer>();
        int[][] masout;
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int masi : mas[i]) {
                if (masi > max) max = masi;
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    columns.add(j);
                    rows.add(i);
                }
            }
        }
        masout = new int[mas.length - rows.size()][mas.length - columns.size()];


        for (int i = 0; i < mas.length; i++) {
            jampcolumn = 0;
            for (int j = 0; j < mas.length; j++) {

                if (columns.contains(j)) {
                    System.out.print(" ");
                    jampcolumn++;
                    continue;
                }
                if (rows.contains(i)) {
                    System.out.println();
                    jampcow++;
                    break;
                }
                System.out.print(String.valueOf(mas[i][j]) + " ");
                masout[i - jampcow][j - jampcolumn] = mas[i][j];
            }
            System.out.println();
        }
        return masout;
    }
}