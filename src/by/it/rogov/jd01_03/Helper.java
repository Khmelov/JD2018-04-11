package by.it.rogov.jd01_03;


public class Helper {
    /**
     * Поиск максимума для массива Double
     *
     * @param arr - одномерный массив
     * @return максимум или MAX_VALUE
     */
    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double v : arr) {
                if (max < v) max = v;
            }
            return max;
        }

    }

    /**
     * Поиск минимума для массива Double
     *
     * @param arr - одномерный массив
     * @return минимум или MIN_VALUE
     */


    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double v : arr) {
                if (min > v) min = v;
            }
            return min;
        }
    }

    /**
     * Сортировка  массива Double по возрастания
     *
     * @param arr - одномерный массив
     * @return отсортированный массив
     */


    static void sort(double[] arr) {

        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }

            }
            last--;
        }
        while (swap);
        InOut.printArray(arr);
    }

    /**
     * Умнажение матрицы на вектор
     *
     * @param matrix матрица double
     * @param vector вектор double
     * @return минимум или MIN_VALUE
     */
    static double[] mul(double[][] matrix, double[] vector) {

        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < vector.length; i1++) {
                res[i] = res[i] + matrix[i][i1] * vector[i1];
            }
        }
        return res;
    }

    /**
     * Умнажение матрицы на матрицу
     *
     * @param matrixLeft  матрица double
     * @param matrixRight матрица double
     * @return минимум или MIN_VALUE
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int i1 = 0; i1 < matrixRight[0].length; i1++) {
                for (int i2 = 0; i2 < matrixRight.length; i2++) {
                    res[i][i1] = res[i][i1] + matrixLeft[i][i2] * matrixRight[i2][i1];
                }
            }
        }
        return res;
    }


}
