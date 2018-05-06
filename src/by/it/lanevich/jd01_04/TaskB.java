package by.it.lanevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][]zp = new int[n][4];
        String[] fam= new String[n];
        for (int i = 0;i < fam.length; i++) {
            fam[i] = scanner.next();
        }

        for (int i = 0; i < fam.length; i++) {
            System.out.println("Введите зарплату для "+fam[i]);
            for (int j = 0; j <4 ; j++) {

                zp[i][j]=scanner.nextInt();        }
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|  Фамилия  | Квартал1 | Квартал2 | Квартал3 | Квартал4 | Итого |");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%12s: ",fam[i]);{
            int sum=0;
                for (int j = 0; j < 4; j++) {
                    sum=sum+zp[i][j];
                System.out.printf("%-11d",zp[i][j]);
            }
            System.out.printf("%-4d\n",sum);
        }
        }
        System.out.println("------------------------------------------------------------------");
        double summain=0;
        double sumavg;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                summain=summain+zp[i][j];
            }
        }

        System.out.printf("%-14s%-6.0f","Итого",summain);
        System.out.println();
        sumavg=summain/( 4 * n);
        System.out.printf("%-14s%-9.4f","Средняя",sumavg);
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println();

}
}
