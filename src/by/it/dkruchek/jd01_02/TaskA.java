package by.it.dkruchek.jd01_02;

import java.util.Scanner;

public class TaskA {

    private static void step1(int[] mas){
        int min=mas[0],max=mas[0];
        for (int element : mas) {
            if (element < min)
                min = element;
            else {
                if (element > max)
                    max = element;
            }
        }
        System.out.print(min + " " + max);
    }

    private static void step2(int[] mas){
        int sum = 0;
        for (int element: mas){
            sum = sum + element;
        }
        double average = sum/mas.length;
        for (int element: mas){
            if (element < average){
                System.out.print(element);
            };
        }
    }

    private static void step3(int[] mas){
        int min=mas[0];
        for (int element : mas) {
            if (element < min)
                min = element;
        }
        for (int i = mas.length-1; i >= 0; i--) {
            if (mas[i]==min){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
        }
    }

