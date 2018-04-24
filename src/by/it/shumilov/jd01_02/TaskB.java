package by.it.shumilov.jd01_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int mounth = scan.nextInt();
        double[] mas = new double[3];
        for (int i = 0; i < 3; i++) {
            mas[i] = scan.nextInt();
        }

        step1();
        step2(mounth);
        step3(mas[0], mas[1], mas[2]);
    }
    private static void step1(){
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.valueOf(i*5 + j + 1) + " ");
            }
            System.out.println(' ');
        }
    }
    private  static  void  step2(int month){
        String[] year = {"январь", "февраль", "март","апрель","май","июнь","июль","август","сентябрь", "октябрь","ноябрь","декабрь"};
        try {
        System.out.println(year[month - 1]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("нет такого месяца");
        }


    }
    private static void step3(double a, double b, double c){
        double discriminant = b*b - 4*a*c;
        double[] x;
        if(discriminant > 0) {
            x = new double[2];
            x[0] = (-b - Math.sqrt(discriminant))/(2*a);
            x[1] = (-b + Math.sqrt(discriminant))/(2*a);
            System.out.println(String.valueOf(x[0]) + " " + String.valueOf(x[1]));
        }
        else  if (discriminant == 0){
            x = new double[1];
            x[0] = -b /(2*a);
            System.out.println(String.valueOf(x[0]));
        }
        else {
            System.out.println("корней нет");
        }

    }
}
