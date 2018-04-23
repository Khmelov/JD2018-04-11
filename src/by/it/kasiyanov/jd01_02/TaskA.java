package by.it.kasiyanov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mas[] = new int[10];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();

        }
        step1(mas);
        step2(mas);
        step3(mas);
    }



    private static void step1(int mas[]){
        int max = mas[0];
        int min = mas[0];

        for (int element : mas) {
            if (max < element){
                max = element;
            }
            if (min > element){
                min = element;
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int mas[]){
        int sum = 0;
        double middle;

        for (int i : mas) {
            sum = sum + i;
        }

        middle = sum / mas.length;

        for (int i : mas) {
            if (i < middle){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] mas) {
        int min = mas[0];
        for (int element : mas) {
            if (min > element) {
                min = element;
            }
        }
        for (int element = (mas.length - 1); element >= 0; element--) {
            if (mas[element] == min) {
                System.out.print(element + " ");
            }
        }

    }


    }
