package by.it.kasiyanov.jd01_03;

import java.util.Arrays;

public class Helper {

    /**
     *Находит минимальное значение в переданном
     *одномерном мвссиве чисел
     * @param arr входной одномерный массив чисел
     * @return min минимальное значение на выходе
     */
    static double findMin(double[ ] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    /**
     *Находит максимальное значение в переданном
     *одномерном мвссиве чисел
     * @param arr входной одномерный массив чисел
     * @return max максимальное значение на выходе
     */
    static double findMax(double[ ] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    /**
     *Сортирует одномерный мвссив чисел
     *в порядке возрастания
     * @param arr входной одномерный массив чисел
     * @return res выходной одномерный массив чисел
     */
    static void sort(double[ ] arr){
        Arrays.sort(arr);
    }

    /**
     *Перемножает матрицу на вектор
     * @param matrix входной дввухмерный массив чисел (матрица)
     * @param vector входной одномерный массив чисел (вектор)
     * @return res выходной одномерный массив чисел
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double res[] = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] = res[i] + matrix[i][j] * vector[j];
            }
        }
        return res;
    }

    /**
     *Перемножает матрицу на матрицу
     * @param matrixLeft входной дввухмерный массив чисел (матрица)
     * @param matrixRight входной дввухмерный массив чисел (матрица)
     * @return res выходной дввухмерный массив чисел (матрица)
     */
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
