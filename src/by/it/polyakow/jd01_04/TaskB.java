package by.it.polyakow.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main (String[] args){
        Scanner scan=new Scanner(System.in);
        int n = scan.nextInt();
        String[] fam = new String[n];
        for (int i = 0; i < fam.length; i++) {
            fam[i]=scan.next();
        }

        int[][] mas = new int[n][4];
        for (int i = 0; i < mas.length; i++) {
            System.out.println("Введите зарплату для "+fam[i]);
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = scan.nextInt();
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n","Фамилия", "Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("----------------------------------------------------------");
        int num=0;
        int sum=0;
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%-10s", fam[i]+":");
            for (int j = 0; j < mas[0].length; j++) {
                num=num+mas[i][j];
                System.out.printf("% -10d",mas[i][j]);
                
            }
            sum= sum+num;
            System.out.printf("%-10d\n",num);
            System.out.println();

        }
        System.out.println("----------------------------------------------------------");

        System.out.printf("%-10s%-10d\n","Итого",sum);




        }







    }


