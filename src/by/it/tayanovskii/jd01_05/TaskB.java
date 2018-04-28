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

        double a = 0;
        double b = 0;

        for (double x = -5.5; x < 2; x+= 0.5) {

            if ( x/2 > -2 && )
                b = sin(x * x);
            else if (-2 < x && x < 0.4)
                b = cos(x * x);
            else if (x == 0.4)
                b = atan(x * x);
            else
            {
                System.out.println("Корней нет");
            }
a=log(abs(b+2.74));
            System.out.println("a=" + a);

        }

    }

}