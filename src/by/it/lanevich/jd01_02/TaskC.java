package by.it.lanevich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mas[][];
        mas = step1(n);
        step2(mas);
    }

    private static int[][] step1(int n) {
        int k;
        int l;
        int mas[][] = new int[n][n];
        do {
            k = 0;
            l = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (mas[i][j] == n) k = 1;
                    if (mas[i][j] == (-1) * n) l = 1;
                }
            }
        } while ((k != 1) || (l != 1));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println("\n");
        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int s = 0;
        int s1 = 0;
        int y;
        for (int[] ma : mas)
            for (int j = 0; j < mas.length; j++)
                if (ma[j] > 0) {
                    for (y = j + 1; y < mas.length; y++) {
                        s1 = 0;
                        if (ma[y] > 0) break;
                        else s1 = s1 + ma[y];

                    }
                    if (y != mas.length - 1) s = s + s1;
                }
        System.out.print(s);
        return s;
    }


}
