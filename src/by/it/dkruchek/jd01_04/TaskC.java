package by.it.dkruchek.jd01_04;

import java.util.Arrays;

/**
 * Created by Dmitriy.Kruchek on 4/19/2018.
 */
public class TaskC {
    private static double[] merge(double[] part1, double[] part2) {

        double[] mergeResult = new double[part1.length + part2.length];
        //starting indices
        int i = 0, j = 0, k = 0;

        while (i < part1.length && j < part2.length) {
            if (part1[i] < part2[j]) {
                mergeResult[k++] = part1[i++];
            } else {
                mergeResult[k++] = part2[j++];
            }
        }
        while (i < part1.length) {
            mergeResult[k++] = part1[i++];
        }
        while (j < part2.length) {
            mergeResult[k++] = part2[j++];
        }
        return mergeResult;
    }

    // iterative merge sort
    private static double[] mergeSort_(double[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            double[] left = Arrays.copyOfRange(array, 0, mid);
            double[] right = Arrays.copyOfRange(array, mid, array.length);

            return merge(mergeSort_(left), mergeSort_(right));
        }
        else return array;
    }

    static void mergeSort(double[] array) {
        if (array.length >= 2) {
            double[] leftArray = Arrays.copyOfRange(array, 0, array.length / 2);
            double[] rightArray = Arrays.copyOfRange(array, array.length / 2, array.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            for (int i = 0, j = 0, k = 0; i < leftArray.length || j < rightArray.length; k++) {
                if (i >= leftArray.length || (j < rightArray.length && leftArray[i] > rightArray[j])) {
                    array[k] = rightArray[j++];
                }
                else {
                    array[k] = leftArray[i++];
                }
            }
        }
    }

    static int binarySearch(double[] array, double value){

        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex <= endIndex) {

            int midIndex = (startIndex + endIndex) / 2;
            double midValue = array[midIndex];

            if (midValue == value){
                return midIndex;
            }
            else if (midValue < value){
                startIndex = midIndex + 1;
            }
            else if (midValue > value){
                endIndex = midIndex - 1;
            }
        }
        return -1;
    }

    static void buildOneDimArray(String line){
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V", 5);

        double firstIndex = arr[0];
        double lastIndex = arr[arr.length-1];
        Helper.sort(arr);
        InOut.printArray(arr, "V", 4);

        int firstElemIndex = binarySearch(arr, firstIndex);
        int lastElemIndex = binarySearch(arr, lastIndex);

        System.out.println("Index of first element=" + firstElemIndex);
        System.out.println("Index of last element=" + lastElemIndex);
    }

}

