package by.it.tayanovskii.jd01_04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }


    static void buildOneDimArray(String line) {
//        формирует из строки line массив вещественных чисел,
//            (можно скопировать для этого класс InOut, написанный в jd01_03 Задание A)
// выводит в 5 колонок этот массив с названием V и индексами (тоже InOut),
//        например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
// сортирует этот массив по возрастанию (см. Helper.sort в jd01_03 Задание B)
// еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
// выполняет вычисление новых (после сортировки) индексов первого и последнего элемента
//        исходного массива и печатает их в виде:
//    Index of first element=2
//        Index of last element=7

        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println("first element=" + binarySearch(array, first));
        System.out.println("last element=" + binarySearch(array, last));


    }

    private static void mergeSort(double[] array) {


        double[] temp = mergeSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }

    }

    private static double[] mergeSort(double[] array, int left, int right) {



        if (left < right) {
            int m = (left + right) / 2;
            return merge(mergeSort(array, left, m), mergeSort(array, m +1, right));
        }
        double[] result = new double[1];
        result[0] = array[left];
        return result;

    }

    private static double[] merge(double[] part1, double[] part2) {


        int len_1 = part1.length, len_2 = part2.length;
        int len_res = len_1 + len_2;
        int i_1 = 0, i_2 = 0;

        double result[] = new double[len_res];

        for (int i = 0; i < len_res; i++) {
            if (i_2 < len_2 && i_1 < len_1) {
                if (part1[i_1] > part2[i_2]) result[i] = part2[i_2++];
                else result[i] = part1[i_1++];
            } else if (i_2 < len_2)
                result[i] = part2[i_2++];
            else result[i] = part1[i_1++];
        }
        return result;

    }

    static int binarySearch(double[] array, double value) {

        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;

            if (array[m] == value) return m;
            else if (array[m] > value) r = m - 1;
            else l = m + 1;
        }
        return -1;

    }


}
