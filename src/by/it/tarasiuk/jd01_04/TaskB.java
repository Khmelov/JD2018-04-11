package by.it.tarasiuk.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main (String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите количество работников:");
        int n = scan.nextInt();
        System.out.println("Введите их фамилии:");
        String[] surname = new String[n];
        for (int i = 0; i < surname.length; i++) {
            surname[i]=scan.next();
        }
        int[][] salary = new int[n][4];
        for (int i = 0; i < surname.length; i++) {
            System.out.println("Введите зарплату для " + surname[i] +":");
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scan.nextInt();
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Фамилия   Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("-------------------------------------------------------");
        int sumTotal=0;
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s: ",surname[i]);
            int sum=0;
            for (int j = 0; j < salary[i].length; j++) {
                sum+=salary[i][j];
                System.out.printf("%-10d", salary[i][j]);
            }
            System.out.printf("%-5d\n",sum);
            sumTotal+=sum;
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Итого: " + sumTotal);
        double averageSalary=(double)sumTotal/(n*4);
        System.out.print("Средняя квартальная зарплата: ");
        System.out.printf("%-10.5f",averageSalary);

    }
}

