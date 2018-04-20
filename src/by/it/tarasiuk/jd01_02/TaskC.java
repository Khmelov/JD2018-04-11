package by.it.tarasiuk.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] ars) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);
        step1(n);
        step2(mas);
        step3(mas);
    }

    static int[][] step1(int n) {
        int arrElement;
        int[][] mas=new int[n][n];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < (mas.length - 1); j++) {
                arrElement = (int) (Math.random() * ((2 * n) + 1)) - n;
                mas[i][j] = arrElement;
            }
        }
        return mas;
    }

    static void step2(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(mas[i][j] + " ");
                if (j == (mas.length-1)) System.out.println();
            }
        }
    }
    static void step3(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j] > 0 && (j < (mas.length-1))) sum += mas[i][j+1];
            }
        }
        System.out.println(sum);
    }

}