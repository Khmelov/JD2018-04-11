package by.it.zaleschonok.jd01_03;

/**
 * Created by Andrey on 17.04.2018.
 */
public class Helper {
    public static void main(String[] args) {
        double[] res = new double[]{6.5, 3.1, 5.72};
        findMin(res);
        findMax(res);
//        sort(res);
    }

    static double findMin(double[] arr) {
        double min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        System.out.println("Минимальное значение массива " + min);
        return min;
    }


    static double findMax(double[] arr) {
        double max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        System.out.println("Максимальное значение массива " + max);
        return max;

    }


    static void sort(double[] arr) {
        for (int i = arr.length - 1; i >= 2; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }

    }


}
