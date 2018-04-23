package by.it.zakharenko.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }


    private static void step1() {

        double y = 0.0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("For a=%3.2f y=%g\n", a, y);

        }

    }


    private static void step2() {
        double a = 0.0;
        double b = 0.0;
        for (double i = -5.5; i < 2; i += 0.5) {
            double x = i / 2;
            if (x > -2 && x <= -1) {
                b = sin(pow(i, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("For x/2=%3.2f a=%g\n", x, a);
            }
            else if (x > -1 && x <= 0.2) {
                b = cos(pow(i, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("For x/2=%3.2f a=%g\n", x, a);
            }
            else if (x == 0.2) {
                b = 1.0 / tan(pow(i, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("For x/2=%3.2f a=%g\n", x, a);
            }
            else {
                System.out.printf("For x/2 = " + x + " ");
            }

        }
    }
}
