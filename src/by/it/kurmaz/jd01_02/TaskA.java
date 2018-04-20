package by.it.kurmaz.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter number # " + i);
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }


    private static void step1(int[] mas) {
        int max = mas[0], min = mas[0];
        for (int i : mas) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas) {
        double sum = 0;
        for (int i: mas)
            sum += i;
        double average = sum / mas.length;
        for (int i: mas) {
            if (i < average)
                System.out.println(i);
        }
    }

    private static void step3(int[] mas) {
        int min = mas[0];
        for (int i : mas) {
            if (i < min)
                min = i;
        }
        for (int i = mas.length - 1; i >= 0 ; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }
    }
}
