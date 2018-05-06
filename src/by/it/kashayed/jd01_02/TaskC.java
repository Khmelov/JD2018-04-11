package by.it.kashayed.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mas[][]= new int[n][n];
        step1(mas, n);

    }

    private static void step1(int[][] mas, int n) {
        Random random = new Random();
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                int t =-n+random.nextInt(n-n+1);
                System.out.println(t);
                if(t==-n ||t==n) System.out.println("s");
                else mas[i][j]=t;
            }
        }


    }
}
