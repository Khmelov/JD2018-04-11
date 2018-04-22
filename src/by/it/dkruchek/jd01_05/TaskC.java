package by.it.dkruchek.jd01_05;

import java.util.Random;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

/**
 * Created by Dmitriy.Kruchek on 4/22/2018.
 */

class InOut {
    /**
     * Parses a string line of doubles into an array
     * @param line the string to be parsed
     * @return array of doubles
     */
    static double[] getArray(String line){
        String[] stringArray = line.split("\\s+");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    /**
     *
     * @param arr the array to print
     */
    static void printArray(double[ ] arr){
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr the array to print
     * @param name name of the array to add
     * @param columnCount number of columns to print
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[ %-2d ]=%-9.6f", i, arr[i]);
            col++;
            if ((0==col%columnCount) || (arr.length - 1 == i)){
                System.out.println();
            }

        }
    }
}

public class TaskC {

    static void step1() {
        double xMin = 5.33, xMax = 9;
        Random random = new Random();
        int arrLength  = random.nextInt(20) + 1 + 20;
        double xDelta = (xMax - xMin) / arrLength;
        double[] arr = new double[arrLength];
        double x = xMin;
        int newArrLength = 0;
        for (int i = 0; i < arrLength; i++, x += xDelta) {
            arr[i] = cbrt(x * x + 4.5);
            if (arr[i] > 3.5) newArrLength++;
        }
        double[] newArray = new double[newArrLength];
        int newArrayIndex = 0;
        double newArrMultiplied = 1;
        for (double v : arr) {
            if (v > 3.5){
                newArray[newArrayIndex] = v;
                newArrayIndex++;
                newArrMultiplied *= v;
            }
        }
        System.out.println("Массив А");
        InOut.printArray(arr, "Массив А", 5);
        System.out.println("Массив B");
        InOut.printArray(newArray, "Массив B", 5);
        System.out.println("Среднее арифметическое массива B = " + pow(newArrMultiplied, 1.0/newArrLength));
    }

    public static void main(String[] args) {
        step1();

    }


}


