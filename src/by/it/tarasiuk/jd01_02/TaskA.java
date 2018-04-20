package by.it.tarasiuk.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] ars) {
        Scanner scanner=new Scanner(System.in);
        int[] mas=new int[10];
        for (int i = 0; i < mas.length ; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min=mas[0];
        int max=mas[0];
        for (int element:mas) {
            if(min>element) min=element;
            if(max<element) max=element;
        }
        System.out.print(min + " ");
        System.out.println(max);
    }

    static void step2(int[] mas) {
        double sum=0;
        for (int elementmin:mas ){
            sum+=elementmin;
        }
        double avg=sum/mas.length;

        for (int element:mas) {
            if(avg>element) System.out.print(element + " ");
        }
        System.out.println();
    }

    static void step3(int[] mas) {
        int min=mas[0];
        for (int element:mas) {
            if (min > element) min = element;
        }
        for (int i = mas.length-1; i>=0 ; i--) {
            if (mas[i]==min) System.out.print(i + " ");
        }
    }
}
