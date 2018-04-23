package by.it.kashayed.jd01_01;

import java.util.Scanner;

public class MyFirstClass {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int[]mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
           mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step3(int[] mas) {
        int x = mas[1];
        int z = 0;
        int[] y = new int[mas.length];
        for (int element :mas){
            if (x>element){
                x= element;
            }
        }
        for (int i = mas.length-1; i >=0 ; i--) {
            if (mas[i] == x){
                z=i;
                System.out.println(z);
            }
        }

    }

    private static void step2(int[] mas) {
        double x = 0;
        double y = 0;
        for (int i = 0; i < mas.length; i++) {
           x = x + mas[i];
        }
        y = x/mas.length;
        for (int element : mas){
            if (y>element)
                System.out.println(element);
        }

    }

    private static void step1(int[] mas) {
        int min = mas[1];
        int max = mas[1];
        for (int element :mas){
            if (element<min){
                min=element;
            }
            if(element>max){
                max=element;
            }

        }
        System.out.println(min + " " + max);
    }

}
