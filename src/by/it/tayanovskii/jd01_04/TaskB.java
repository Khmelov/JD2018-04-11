package by.it.tayanovskii.jd01_04;

import javax.naming.Name;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int count_Fam = scanner.nextInt();
        String[] last_Name = new String[count_Fam];
        int[][] salary = new int[count_Fam][4];
        for (int i = 0; i < last_Name.length; i++) {
            last_Name[i] = scanner.next();
        }

        for (int i = 0; i < last_Name.length; i++) {
            System.out.println("Введите зарплату для " + last_Name[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }

        }

//        for (int i = 0; i < salary.length; i++) {
//            for (int j = 0; j < salary[i].length; j++) {
//
//                System.out.print(salary[i][j] + " ");
//            }
//            System.out.println();
//        }

        //Вывод инфомации на экран
        double all_Sum = 0;
        System.out.println("------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < last_Name.length; i++) {
            int sum = 0;
            System.out.printf("%7s: ", last_Name[i]);
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
                sum += salary[i][j];
            }
            System.out.printf("%-5d\n", sum);
            all_Sum += sum;
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%-9s%.0f\n","Итого",all_Sum);
        System.out.printf("%-8s%-10.4f","Средняя",all_Sum/(last_Name.length*4));

    }


}
