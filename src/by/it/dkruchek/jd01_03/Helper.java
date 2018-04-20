package by.it.dkruchek.jd01_03;

/**
 * Created by Dmitriy.Kruchek on 4/17/2018.
 */
public class Helper {
    /**
     *
     * @param arr The array to find value in
     * @return minimum element of the array
     */
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

    /**
     *
     * @param arr The array to find value in
     * @return maximum element of the array
     */
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

    /** Impelementation of bubble sort
     *
     * @param arr the array to sort
     */
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

    /** Multiplies a provided matrix and a vector
     *
     * @param matrix the matrix to multiply
     * @param vector the vector to multiply
     * @return the multuplication result
     */
    static double[] mul(double[][] matrix, double[] vector){
        int m = matrix.length;
        int n = matrix[0].length;
        double[] result = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                result[i] += matrix[i][j] * vector[j];
        return result;
    }

    /** Multiplies two provided matrices
     *
     * @param matrixLeft the first matrix to multiply
     * @param matrixRight the second matrix to multiply
     * @return the multuplication result
     */
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
