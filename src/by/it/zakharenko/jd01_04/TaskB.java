package by.it.zakharenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] fam = new String[n];    //"Ivanov", "Petrov", "Sidorov"
        for (int i = 0; i < n; i++) {
            fam[i] = scanner.next();
        }

        int wage[][] = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + fam[i]);
            for (int j = 0; j < 4; j++) {
                wage[i][j] = scanner.nextInt();
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Фамилия Квартал1 Квартал2 Квартал3 Квартал4 Итого");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s: ", fam[i]);
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                sum = sum + wage[i][j];

                System.out.printf("%-10d", wage[i][j]);

            }

            System.out.printf("%-4d\n", sum);

        }

        int summa = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                summa = summa + wage[i][j];
            }
        }
        System.out.println(summa);


        double sum = 0.0;
        double sred = 0.0;

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < n; i++) {
                sum = sum + wage[i][j];
                sred = sum / 12.0;
            }

        }
        System.out.printf("%.4f \n", sred);
    }
}
