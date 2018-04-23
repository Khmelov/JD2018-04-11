package by.it.kasiyanov.jd01_04;

import java.util.Arrays;

public class Helper {

    static double findMin(double[ ] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    static double findMax(double[ ] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    static void sort(double[ ] arr){
        Arrays.sort(arr);
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double res[] = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] = res[i] + matrix[i][j] * vector[j];
            }
        }
        return res;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double res[][] = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    res[i][j] = res[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return res;
    }

}
