package by.it.shumilov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String[] arrayFam = new String[n];
        for (int i = 0; i < n; i++) {
            arrayFam[i] = scan.next();
        }
        int [][] zarp= new int[n][4];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + arrayFam[i]);
            for (int j = 0; j < 4; j++) {
                zarp[i][j] = scan.nextInt();
            }
        }

        System.out.println("______________________________________________________");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("______________________________________________________");
        int allSum = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s: ", arrayFam[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += zarp[i][j];
                System.out.printf("%-10d", zarp[i][j]);
            }
            allSum += sum;
            System.out.printf("%-5d%n",sum);


        }


        System.out.println("______________________________________________________");
        System.out.println("Итого    " + allSum);
        System.out.println("Средняя  " + allSum/Double.valueOf(n*4));

        //        Затем введите одномерныи массив их фамилии (next() в сканере).
// Введите двумерныи массив их зарплат за 4 квартала (N строк и 4 столбца).
// Зарплаты имеют тип int.
// Нужно для каждои фамилии выводить подсказку
// После подсказки можно через пробел вводить с консоли 4 цифры зарплат по кварталам (nextInt() в
//        сканере).
// Построите в консоли таблицу доходов людеи по кварталам с фамилиями и
//        итогом за год в последнеи колонке.

    }
}
