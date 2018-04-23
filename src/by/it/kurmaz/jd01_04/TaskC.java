package by.it.kurmaz.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Enter a line");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println("Index of first element="+binarySearch(array, first));
        System.out.println("Index of last element="+binarySearch(array, last));
    }

    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left)/2;
            if (value == array[middle])
                return middle;
            else if (value < array[middle])
                right = middle;
            else if (value >= array[middle])
                left = middle + 1;
        }
        return Integer.MAX_VALUE;
    }

    static void mergeSort(double[] array) {
        int left = 0;
        int right = array.length - 1;
        sort(array, left, right);
    }
    static void sort(double[] array, int left, int right) {
        if (left >= right){
            return;
        }
        int middle = left + (right - left)/2;
        sort (array, left, middle);
        sort (array, middle+1, right);
        double[] buf = Arrays.copyOf(array, array.length);
        int leftArrayCounter = left;
        int rigthArrayCounter = middle + 1;
        for (int i = left; i <=right ; i++) {
            if (leftArrayCounter > middle){
                array[i] = buf[rigthArrayCounter];
                rigthArrayCounter++;
            }
            else if (rigthArrayCounter > right) {
                array[i] = buf[leftArrayCounter];
                leftArrayCounter++;
            }
            else if (buf[leftArrayCounter]> buf[rigthArrayCounter]) {
                array[i] = buf[rigthArrayCounter];
                rigthArrayCounter++;
            }
            else {
                array[i] = buf[leftArrayCounter];
                leftArrayCounter++;
            }
        }
    }
}
