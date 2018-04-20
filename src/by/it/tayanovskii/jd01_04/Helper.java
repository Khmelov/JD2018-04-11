package by.it.tayanovskii.jd01_04;

public class Helper {

    /**
     * @param arr входной массив
     * @return min - минимальный элемент массива
    */
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double element : arr) {
            if (min > element) min = element;

        }
        return min;
    }

    /**
     * @param arr входной массив
     * @return max - максимальный элемент массива
     */

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (max < element) max = element;

        }
        return max;
    }

    /**
     * @param arr входной массив, который необходимо отсортировать по возрастанию
     */

    static void sort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    double buff = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buff;
                }

            }

        }
    }



    /**
     * @param matrix входная матрица
     * @param vector входной вектор
     * @return result - результат умножения
     */

    static double[] mul(double[][] matrix, double[] vector)
    {
        double [] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i]=  result[i]+matrix[i][j]*vector[j];
            }
        }
        return result;

    }

    /**
     * @param matrixLeft первая входная матрица (которую умножают)
     * @param matrixRight вторая входная матрица (на которую умножают)
     * @return result - результат умножения
     */

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight)
    {
        double [][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j]=result[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return result;
    }
}
