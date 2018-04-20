package by.it.kashayed.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void  main(String[] args){

        Scanner scanner=new Scanner(System.in);
        int[] mas= new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }
        step1 (mas);
        step2 (mas);
        step3 (mas);
    }

    private static void step3(int[] mas) {
        int x = mas[0];
        for (int element : mas){
            if (x>element) x = element;
        }
        for (int i = mas.length-1; i >= 0 ; i--) {
            if (mas[i]==x){
                System.out.print(i+" ");
            }
        }

    }

    private static void step2(int[] mas) {
        double x=0 ;
        for (int element :mas){
            x = x+element;
        }
        x=x/mas.length;
        for (int element :mas){
            if(element <x){
                System.out.println(element);
            }
        }
    }

    private static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int element : mas){
            if (min>element) min = element;
            if (max<element) max = element;
        }
        System.out.println(min + " " + max);
    }
}
