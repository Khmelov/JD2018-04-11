package by.it.rogov.jd01_05;

import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {

        step1();
    }

    private static void step1() {
        double a = 5.33;
        double b = 9;
        int c = 33;
        int j = 0;
        int x = 0;
        int y = 0;
        double sqrtgeom = 1;
        double step = (b - a) / (c - 1);
        System.out.println(step);
        double[] array = new double[c];
        for (double i = a; i <= b; i += step) {
            array[j] = pow((pow(i, 2) + 4.5), 1.0 / 3.0);
            System.out.printf("A[%02d] %.8f    ", j, array[j]);
            x++;
            if (array[j] > 3.5) {
                sqrtgeom = sqrtgeom * array[j];
                y++;
            }
            j++;
            if (x == 7) {
                System.out.println();
                x = 0;
            }

        }
        j = 0;
        double[] arrs = new double[y];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) arrs[j++] = array[i];
        }
        System.out.println();
        System.out.printf("Среднегеометричное %.4f", (sqrtgeom = pow(sqrtgeom, 1.0 / y)));

    }


}
