package by.it.sharin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        String[]fam=new String[n];
        for (int i = 0; i < n; i++) {
            fam[i]=scanner.next();
        }
        int[][]z=new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                z[i][j]=scanner.nextInt();
            }
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Фамилия Квартал 1 Квартал 2 Квартал 3 Квартал 4 Итого");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s: ",fam[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum=sum+z[i][j];
                System.out.printf("%-10d",z[i][j]);
            }
            System.out.printf("%-4d\n",sum);
        }
        System.out.println("-----------------------------------------------------");
//        int n = 3;
//        String[] fam = {"Ivanov", "Petrov", "Sidorov"};
//        int[][]z={
//                {1,2,3,4},
//                {11,22,33,44},
//                {111,222,333,444}
//        };
//        System.out.println("-----------------------------------------------------");
//        System.out.println("Фамилия Квартал 1 Квартал 2 Квартал 3 Квартал 4 Итого");
//        System.out.println("-----------------------------------------------------");
//        for (int i = 0; i < n; i++) {
//            System.out.printf("%7s: ",fam[i]);
//            int sum = 0;
//            for (int j = 0; j < 4; j++) {
//                sum=sum+z[i][j];
//                System.out.printf("%-10d",z[i][j]);
//            }
//            System.out.printf("%-4d\n",sum);
//        }
//        System.out.println("-----------------------------------------------------");
    }
}
