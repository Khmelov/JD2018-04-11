package by.it.kashayed.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String [] familii = new String[n];
        String [][] zp = new String [n][4];
        for (int i = 0; i < familii.length; i++) {
            familii[i] = scanner.next();
            System.out.println(familii[i]);
        }


    }
}
