package by.it.dkruchek.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Dmitriy.Kruchek on 4/22/2018.
 */
public class TaskB {

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++){
                y = y + pow(7,a) - cos(x);
            }
            System.out.printf("При a = %.2f Сумма y = %f \n", a, y);
        }
    }

    private static void step2() {
        double a, b;
        for (double x = -5.5; x < 2; x += 0.5) {
            if (-2 < x / 2 && x / 2 <= -1)
                b = sin(x * x);
            else if (-1 < x / 2 && x / 2 < 0.2)
                b = cos(x * x);
            else if (x / 2 == 0.2)
                b = 1.0 / tan(x * x);
            else {
                System.out.printf("При x/2=%2.2f значения не определены \n", x / 2);
                continue;
            }
            a = log10(abs(b + 2.74));
            System.out.printf("При x/2=%2.2f a=%.15f \n", x / 2, a);
        }
    }
    public static void main(String[] args) {
        step1();
        step2();
    }
}
