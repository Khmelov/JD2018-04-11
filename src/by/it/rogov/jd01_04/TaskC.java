package by.it.rogov.jd01_04;

import java.util.Scanner;


public class TaskC {

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);


        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);


        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }

    }


    static void mergeSort(double[] array) {
        double[] ar = new double[array.length];
        int left;
        int right;
        left = 0;
        right = array.length - 1;
        ar = mergeSort(array, left, right);
        for (int i = 0; i < ar.length; i++) {
            array[i] = ar[i];
        }


    }

    /**
     * @param array одномерный массив
     * @param left  начало массива
     * @param right окончание массива
     * @return
     */
    private static double[] mergeSort(double[] array, int left, int right) {

        right = right - left;
        left = 0;
        if (left < right) {
            int s;
            s = (left + right) / 2;
            double[] array1 = new double[s - left + 1];
            double[] array2 = new double[right - s];
            for (int i = 0; i <= s; i++) {
                array1[i] = array[i];

            }
            for (int i = s + 1; i <= right; i++) {
                array2[i - (s + 1)] = array[i];
            }
            return merge(mergeSort(array1, left, s), mergeSort(array2, (s + 1), right));


        }
        return array;
    }

    /**
     * @param part1 одномерный массив отсортированный
     * @param part2 одномерный масив отсортированный
     * @return отсортированый массив размерности part1+part2
     */
    private static double[] merge(double[] part1, double[] part2) {
        double[] array = new double[part1.length + part2.length];
        int i = 0, j = 0;
        while ((i + j) < (part1.length + part2.length)) {
            if ((part2.length) != j && ((part1.length) == i || part2[j] < part1[i])) {
                array[i + j] = part2[j++];
            } else {
                array[i + j] = part1[i++];
            }


        }


        return array;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }
}
