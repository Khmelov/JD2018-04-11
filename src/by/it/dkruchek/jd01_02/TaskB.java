package by.it.dkruchek.jd01_02;

import java.util.Scanner;

public class TaskB {

    static void step1(){
        for (int i = 1; i <= 25; i++){
            System.out.print(i + " ");
            if (i%5==0){
                System.out.println();
            }
        }
    }

    static void step2(int month){
        String monthString;
        switch (month) {
            case 1:  monthString = "январь";
                break;
            case 2:  monthString = "февраль";
                break;
            case 3:  monthString = "март";
                break;
            case 4:  monthString = "апрель";
                break;
            case 5:  monthString = "май";
                break;
            case 6:  monthString = "июнь";
                break;
            case 7:  monthString = "июль";
                break;
            case 8:  monthString = "август";
                break;
            case 9:  monthString = "сентябрь";
                break;
            case 10: monthString = "октябрь";
                break;
            case 11: monthString = "ноябрь";
                break;
            case 12: monthString = "декабрь";
                break;
            default: monthString = "нет такого месяца";
                break;
        }
        System.out.println(monthString);
    }

    static void step3(double a, double b, double c) {
        double discriminant = ((b * b) + (-4 * a * c));
        if (discriminant < 0) {
            System.out.println("корней нет");
        }
        else if (discriminant == 0) {
            double x = (-b / (2 * a));
            System.out.println(x);
        }
        else {
            double x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monthNumber = scanner.nextInt();
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step1();
        step2(monthNumber);
        step3(a, b, c);
    }
}
