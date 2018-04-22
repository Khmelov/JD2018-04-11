package by.it.kasiyanov.jd01_04;

import java.util.Scanner;

public class TaskC  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[(array.length - 1)];
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println("Index of first element=" + binarySearch(array, first));
        System.out.println("Index of last element=" + binarySearch(array, last));
    }

    static void mergeSort(double[ ] array){
        int left = 0;
        int right = array.length;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        array = mergeSort(array, left, right);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static double[ ]mergeSort(double[ ] array, int left, int right){
        if(left >= (right - 1)){
            return array;
        }
        int m = (right - left) / 2;
        double part1[] = new double[m];
        double part2[] = new double[array.length - m];
        for (int i = 0; i < part1.length; i++) {
            part1[i] = array[i];
        }
        for (int i = 0; i < part2.length; i++) {
            int j = i + m;
            part2[i] = array[j];
        }
        array = merge(mergeSort(part1, left, m), mergeSort(part2, left, part2.length));
        return array;
    }

    private static double[ ] merge(double[ ] part1, double[ ] part2){
        double array[] = new double[part1.length + part2.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if(j == part1.length){
                array[i] = part2[k];
                k++;
            }
            else if(k == part2.length){
                array[i] = part1[j];
                j++;
            }
            else{
                if(part1[j] < part2[k]){
                    array[i] = part1[j];
                    j++;
                }
                else {
                    array[i] = part2[k];
                    k++;
                }
            }
        }
        return array;
    }

    static int binarySearch(double[ ] array, double value){
        int left = 0;
        int right = array.length;
        int res;
        int m = (right - left) / 2;

        if(value == array[m]){
            return m;
        }
        else if (array[m+1] <= value) {
            /*double part2[] = new double[array.length - m];
            for (int i = 0; i < part2.length; i++) {
                int j = i + m;
                part2[i] = array[j];
            }
            res = binarySearch(part2, value);*/
            left = m + 1;
            res = binarySearch(array, value, left, right);
        }
        else if(array[m-1] >= value ) {
            /*double part1[] = new double[m];
            for (int i = 0; i < part1.length; i++) {
                part1[i] = array[i];
            }
            res = binarySearch(part1, value);*/
            right = m - 1;
            res = binarySearch(array, value, left, right);
        }
        else {
            return (-1);
        }
        return res;
    }

    private static int binarySearch(double[ ] array, double value, int left, int right){
        if (left > right){
            return (-1);
        }
        int m = (right - left) / 2;
        System.out.println(m);

        if (array[m] == value){
            return m;
        }
        else if (array[m-1] >= value){
            return binarySearch(array, value, left, m - 1);
        }
        else if (array[m+1] <= value){
            return binarySearch(array, value, m + 1, right);
        }
        return m;
    }

     /*static int binarySearch(double[ ] array, double value){
        int left = 0;
        int right = array.length;
        boolean again = true;

        while(left <= right && again){
            int m = (right - left) / 2;
            if(value == array[m]){
                again = false;
                return m;
            }
            else if(array[m+1] <= value){
                left = m + 1;
            }
            else if (array[m-1] >= value){
                right = m - 1;
            }
        }
        return (-1);
    }*/

}
