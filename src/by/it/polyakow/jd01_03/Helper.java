package by.it.polyakow.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }

    }


    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static void sort(double[] arr) {
        for (double i = arr.length - 1; i > 0; i--) {
            for (double j = 0; j < i; j++)
                if (arr[(int) j] > arr[(int) (j + 1)]) {
                    double buffer = arr[(int) j];
                    arr[(int) j] = arr[(int) (j + 1)];
                    arr[(int) (j + 1)] = buffer;
                }

        }
    }
}