package by.it.krivenkova.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        //     int n = 3;
     /*   String[] fam = {"Ivanov", "Petrov", "Sidorov"};
        int[][] z={
                {1,2,3,4},
                {11,22,33,44},
                {111,222,333,444}
        };*/

        Integer COUNT_QUARTER = 4;
        System.out.println("Введите количество работников");
        Scanner scanner = new Scanner(System.in);
        Integer countP = scanner.nextInt();
        String[] fam = new String[countP];
        System.out.println("Введите фамилии работников");
        scanner.reset();
        for (int i = 0; i < countP; i++) {
            fam[i] = scanner.next();
        }
        int[][] z= new int[countP][COUNT_QUARTER];
        for (int i = 0; i < fam.length; i++) {
            System.out.println("Введите зарплату для " + fam[i]);
            for (int j = 0; j < COUNT_QUARTER; j++) {
                z[i][j] = scanner.nextInt();
            }
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4 Итого");
        System.out.println("-----------------------------------------------------");
        int totalSum = 0;
        for (int i = 0; i < countP; i++) {
            System.out.printf("%7s: ", fam[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += z[i][j];
                System.out.printf("%-10d", z[i][j]);
            }
            System.out.printf("%4d\n", sum);
            totalSum += sum;
        }

        float averageSum =(float) totalSum / (countP*COUNT_QUARTER);
        System.out.println("-----------------------------------------------------");
        System.out.printf("Итого   " + totalSum);
        System.out.println();
        System.out.printf("Средняя %.4f", averageSum);
    }
}
