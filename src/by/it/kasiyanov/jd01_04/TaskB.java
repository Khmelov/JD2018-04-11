package by.it.kasiyanov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String surname[] = new String[n];
        for (int i = 0; i < surname.length; i++) {
            surname[i] = scanner.next();
        }
        
        int salary[][] = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }

        System.out.println("--------------------------------------------------------");
        String tableHead[] ={"Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого"};
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n",tableHead[0],tableHead[1],tableHead[2],tableHead[3],tableHead[4],tableHead[5]);
        System.out.println("--------------------------------------------------------");

        double avg;
        int all = 0;

        for (int i = 0; i < n; i++) {
            System.out.printf("%-7s: ",surname[i]);
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum = sum + salary[i][j];
                System.out.printf("%-10s",salary[i][j]);
            }
            System.out.printf("%-5d%n",sum);
            all = all + sum;
        }
        System.out.println("--------------------------------------------------------");
        avg = (double) all / ((double)n * 4.0);

        System.out.printf("%-9s%-10s%n", "Итого", all);
        System.out.printf("%-9s%-10.4f%n", "Средняя", avg);
        System.out.println("--------------------------------------------------------");



        

    }
}
