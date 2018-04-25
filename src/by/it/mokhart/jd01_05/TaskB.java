package by.it.mokhart.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        double a;
        for (double x = -6; x < 2; x+=0.5) {
            if ((-2<x/2) && (x/2<=-1)) {
                double b = sin(x*x);
                a = log10(abs(b+2.74));
                System.out.printf("При x/2=%.2f a = %f\n", x/2, a);
            }
            else if ((-1 < x/2) && (x/2 < 0.2)) {
                double b = cos(x*x);
                a = log10(abs(b+2.74));
                System.out.printf("При x/2=%.2f a = %f\n", x/2, a);
            }
            else if (x/2 == 0.2) {
                double b = 1.0/tan(x*x);
                a = log10(abs(b+2.74));
                System.out.printf("При x/2=%.2f a = %f\n", x/2, a);
            }
            else
                System.out.printf("При х/2 = %.2f вычисления не опеределены\n", x/2);
        }
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <=2 ; a+=0.2) {
            for (int x = 1; x <=6 ; x++) {
                y+= pow(7, a) - cos(x);
            }
            System.out.printf("При а=%.2f Сумма y = %f\n", a, y);
        }

    }
}