package by.it.mokhart.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();

        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        step2(month);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }

    public static void step1() {
        int array[][] = new int[5][5];
        int n = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(n + " ");
                n = n + 1;
            }
            System.out.println();
        }
    }

    public static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
                break;
        }

    }

    public static void step3(double a, double b, double c) {
        double dis = Math.pow(b, 2) - 4 * a * c;

        if (dis < 0) {
            System.out.println("корней нет");
        } else if (dis == 0) {
            double x = (-b) / (2 * a);
            System.out.println(x);
        } else {
            double x1 = (-b + Math.sqrt(dis)) / (2 * a);
            double x2 = (-b - Math.sqrt(dis)) / (2 * a);
            System.out.println("x1 = " + x1 + " " + "x2 = " + x2);
        }


    }
}
