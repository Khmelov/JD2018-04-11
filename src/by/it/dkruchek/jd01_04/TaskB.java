package by.it.dkruchek.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 4/18/2018.
 */
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество ");
        int count = scanner.nextInt();
        String[] lastNames = new String[count];
        for (int i = 0; i < count; i++) {
            lastNames[i] = scanner.next();
        }
        int[][] salaries = new int[count][4];

        for (int i = 0; i < lastNames.length; i++)

         {
            System.out.printf("Введите зарплату для %s\n", lastNames[i]);
             for (int j = 0; j < 4; j++) {
                 int salary = scanner.nextInt();
                 salaries[i][j] = salary;
             }

        }

        for (int[] salary : salaries) {
            System.out.println(Arrays.toString(salary));
            }

        System.out.println("-------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("-------------------------------------------------------");

        //out
        int total = 0;
        for (int i = 0; i < count; i++) {
            System.out.printf("%7s: ",lastNames[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {

                sum += salaries[i][j];
                System.out.printf("%-10d", salaries[i][j]);

            }
            total += sum;
            System.out.printf("%4d\n", sum);

        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("Итого%7d\n",total);
        double avg = (double) total/count/4;
        System.out.printf("Средняя%9.4f", avg);
        }

}


