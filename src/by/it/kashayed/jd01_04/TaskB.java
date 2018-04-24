package by.it.kashayed.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        String [] fam = new String[n];
        int [][] zp = new int[n][4];
        for (int i = 0; i < fam.length; i++) {
            fam[i]= scanner.next();
        }
        for (int i = 0; i < zp.length; i++) {

            System.out.println("Введите зарплату для "+fam[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j]= scanner.nextInt();
            }
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итог");
        System.out.println("-----------------------------------------------------");
        int ff =0;
        int []v =new int[n];
        for (int i = 0; i < fam.length; i++) {
            System.out.printf("%-9s",fam[i]);
            int sum = 0;
            for (int z = 0; z <4; z++) {
                sum = sum+zp[i][z];
                v[i]=sum;
                System.out.printf("%-10d",zp[i][z]);
            }
            System.out.printf("%-5d\n",sum);

        }
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < v.length; i++) {
            ff=ff+v[i];
        }
        System.out.printf("%-9s%-10d\n","Итого",ff);
        double kv=0;
        double[]sumk =new double[4];
        for (int i = 0; i < 4; i++) {
            double sr=0;

            for (int j = 0; j < zp.length; j++) {
                sr=sr+zp[j][i];
            }
            sumk[i]=sr/n;
        }
        for (int i = 0; i < sumk.length; i++) {
            kv=kv+sumk[i];
        }
        kv=kv/4;
        System.out.printf("%-9s%-10.4f", "Средня",kv);
    }
}
