package by.it.rogov.jd01_04;

import java.util.Scanner;


public class TaskB {

    /**
     *
     * @ return таблицу зарплат по квартально каждого сотрудника , а так же сумарную и среднуюю по кварталам.
     */
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] famaly = new String[n];
        for (int i = 0; i < n; i++) {
            famaly[i] = scanner.next();
        }
        int[][] solary = new int[n][4];
        System.out.println("Введите зарплату за 4 квартала  ");
        for (int i = 0; i < n; i++) {
            System.out.println("зарплата " + famaly[i]);
            for (int j = 0; j < 4; j++) {
                System.out.println("Квартал " + (j + 1));
                solary[i][j] = scanner.nextInt();
            }

        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("    Фамилия   Квартал1  Квартал2  Квартал3  Квартал4    Итого ");
        System.out.println("--------------------------------------------------------------");
        double result=0;
        for (int i = 0; i < n; i++) {

            System.out.printf("%8S:         ", famaly[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum = sum + solary[i][j];
                System.out.printf("%-10s", solary[i][j]);
            }
            result=result+sum;
            System.out.printf("%-4d%n", sum);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.print(" Итого           ");
        System.out.printf("%-5.0f",result);
        System.out.println();
        System.out.print(" Средняя         ");
        System.out.printf("%-8.4f",result/(4*n));
    }
}
