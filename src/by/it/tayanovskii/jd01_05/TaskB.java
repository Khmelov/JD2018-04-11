package by.it.tayanovskii.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.println(y);
        }

        double a;
        double b;

        for (double x = -5.5; x < 2; x += 0.5) {

            if (x/2 > -2 && x/2 <= -1)
                b = sin(x * x);
            else if (-1 < x/2 && x/2 < 0.2)
                b = cos(x * x);
            else if (x/2 == 0.2)
                b = atan(x * x);
            else {
                System.out.println("x/2 = " + x/2);
                System.out.println("Корней нет");
                continue;
            }
            a = log10(abs(b + 2.74));
            System.out.println("x/2 = " + x/2);
            System.out.println("a=" + a);

        }

    }

}