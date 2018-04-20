package by.it.dkruchek.jd01_04;


import java.util.Scanner;

/**
 * Created by Dmitriy.Kruchek on 4/18/2018.
 */
class InOut {

    static double[] getArray(String line){
        String[] stringArray = line.split("\\s+");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    static void printArray(double[ ] arr){
        for (double v : arr) {
            System.out.print(v + " ");
        }
    }

    static void printArray(double[] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%-9.4f", i, arr[i]);
            col++;
            if ((0==col%columnCount) || (arr.length - 1 == i)){
                System.out.println();
            }

        }
    }
}

class Helper {
    static double findMin(double[] arr){
        if (0 == arr.length){
            return Double.MIN_VALUE;
        }
        double minElement = arr[0];
        for (double v : arr) {
            if (v < minElement){
                minElement = v;
            }
        }
        return minElement;
    }

    static double findMax(double[] arr){
        if (0 == arr.length){
            return Double.MAX_VALUE;
        }
        double maxElement = arr[0];
        for (double v : arr) {
            if (v > maxElement){
                maxElement = v;

            }
        }
        return maxElement;
    }

    static void sort(double[] arr){

        int n = arr.length;
        double temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static double[] mul(double[][] matrix, double[] vector){
        int m = matrix.length;
        int n = matrix[0].length;
        double[] result = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                result[i] += matrix[i][j] * vector[j];
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        int m1 = matrixLeft.length;
        int n1 = matrixLeft[0].length;
        int n2 = matrixRight[0].length;
        double[][] result = new double[m1][n2];
        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n2; j++)
                for (int k = 0; k < n1; k++)
                    result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
        return result;
    }
}



public class TaskA {
    private static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V", 5);

        double firstIndex = arr[0];
        double lastIndex = arr[arr.length-1];
        Helper.sort(arr);
        InOut.printArray(arr, "V", 4);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==firstIndex) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==lastIndex) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }


    }



    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }
}
