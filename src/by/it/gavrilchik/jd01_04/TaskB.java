package by.it.gavrilchik.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        String[] fam = {"Ivanov", "Petrov", "Sidorov"};
        int[][] z= {
                {1, 2, 3, 4},
                {11, 22, 33, 44},
                {111, 222, 333, 444}
        };


        for (int i = 0; i < n; i++) {
            System.out.printf("%7s: ",fam[i]);
            int sum=0;
            for (int j = 0; j < 4; j++) {
                sum=sum+z[i][j];
                System.out.printf("%-10d\n",z[i][j]);

            }
            System.out.printf("%");
        }

    }






}
