package by.it.obmetko.jd01_05;


import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double[] arrA = new double[36];
        step1(arrA);

    }

    private static void step1(double[] arrA) {
        double j = 5.4;
        int sum = 0;
        double compos = 1.0;
        for (int i = 0; i < arrA.length; i++) {
            if (i == 0) arrA[i] = pow((5.33 * 5.33 + 4.5), 1.0 / 3);
            else if (i == arrA.length - 1) arrA[i] = pow((9.0 * 9.0 + 4.5), 1.0 / 3);
            else {
                arrA[i] = pow((j * j + 4.5), 1.0 / 3);
                j = j + 0.1;
            }
        }
        System.out.println("Массив A[]");
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] > 3.5) sum++;
            System.out.printf("A[ %d ] = %-10.5f", i, arrA[i]);
            if ((0 == (i + 1) % 5) || (arrA.length == i + 1))
                System.out.println();
        }
        double[] arrB = new double[sum];
        sum = 0;

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] > 3.5) {
                arrB[sum] = arrA[i];
                compos = compos * arrA[i];
                sum++;
            }
        }
        System.out.println("\nМассив B[] из элементов массива A > 3.5");
        for (int i = 0; i < arrB.length; i++) {
            System.out.printf("B[ %d ] = %-10.5f", i, arrB[i]);
            if ((0 == (i + 1) % 5) || (arrA.length == i + 1))
                System.out.println();
        }
        System.out.println("\nСреднее геометрическое значение массива B = " + pow(compos, 1.0 / arrB.length));
    }


}

