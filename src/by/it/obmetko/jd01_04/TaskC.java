package by.it.obmetko.jd01_04;

import java.util.Scanner;
import java.util.Arrays;


    public class TaskC {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            buildOneDimArray(line);
            double[] m = {1, 3, 4, 2};
            mergeSort(m);
            binarySearch(m, 3);
        }


        private static int binarySearch(double[] array, double value) {
            int l = 0;
            int r = array.length;

            while (l <= r) {
                int m = (l + r) / 2;
                if (value == array[m])
                    return m;
                else if (value > array[m])
                    l = m + 1;
                else
                    r = m - 1;
            }
            return -1;

        }


        public static void mergeSort(double[] arr) {
            Arrays.sort(arr);

                }



        static void buildOneDimArray(String line) {
            double[] array = InOut.getArray(line);
            System.out.println("Unsorted array");
            InOut.printArray(array, "V", 5);
            double first = array[0];
            double last = array[array.length - 1];
            Helper.sort(array);
            System.out.println("Sorted array");
            InOut.printArray(array, "V", 4);
            System.out.println("Find new indexes");
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
    }

