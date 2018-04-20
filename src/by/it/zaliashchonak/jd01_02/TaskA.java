package by.it.zaliashchonak.jd01_02;

import java.util.Scanner;




public class TaskA {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] mas=new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }
//        System.out.println(mas.length);
        step1(mas);
        step2(mas);
        step3(mas);

    }


    private static void step1(int[] mas) {
        int min=mas[0];
        int max=mas[0];

        for (int element : mas){
            if (min>element) min=element;
            if (max<element) max=element;
        }
        System.out.println("минимум и максимум в одну строку через пробел:");
        System.out.println(min+" "+max);

    }
//Вывести на консоль те числа, значение которых строго меньше среднего арифметического (типа double) в этом массиве.
    private static void step2(int[] mas) {
        double sum=0;
        for (int element : mas){
            sum=sum+element;
        }
        double avg=sum/mas.length;
        for (int element : mas) {
            if (element<avg)
                System.out.println(element+" ");

        }
    }

    // Найти и вывести номер (т.е. индекс) самого маленького числа.
    // Если же таких чисел будет несколько, вывести все найденные индексы минимума через пробел в порядке убывания.
    private static void step3(int[] mas) {
        int min=mas[0];

        for (int element : mas){
            if (min>element) min=element;
        }

        for (int i = mas.length-1; i>=0; i--) {
            if (mas[i]==min) {
                System.out.print(i + " ");
            }
        }
    }



}
