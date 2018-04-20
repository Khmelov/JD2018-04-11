package by.it.tarasiuk.jd01_03;

public class Helper {
    /**
     *
     * @param arr передается одномерный массив типа double
     * @return возвращает наименьший член массива
     */
    static double findMin(double[ ] arr){
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m:arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    /**
     *
     * @param arr передается одномерный массив типа double
     * @return возвращает наибольший член массива
     */
    static double findMax(double[ ] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m:arr) {
                if (max < m) max = m;
            }
            return max;
        }

    }

    /**
     *
     * @param arr передается одномерный массив типа double
     * @return возвращает отсортированный по возрастанию одномерный массив типа double
     */
    static double[] sort(double[ ] arr){
        int i = 1;
        while(i < arr.length) {
            if(i == 0 || arr[i-1] <= arr[i]) i++;
            else {
                double temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
        return arr;
    }

    /**
     *
     * @param matrix передается матрица(двумерный массив типа double)
     * @param vector передается вектор(одномерный массив типа double)
     * @return возвращается одномерный массив = матрица * вектор
     */
    static double[] mul(double[][] matrix, double[] vector){
        double[] mulMV=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                mulMV[i] = mulMV[i] + matrix[i][j] * vector[j];
        return mulMV;

    }

    /**
     *
     * @param matrixLeft передается левая матрица(двумерный массив типа double)
     * @param matrixRight передается правая матрица(двумерный массив типа double)
     * @return возвращается матрица(двумерный массив типа double) = левая матрица * правая матрица
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] mulMleftMright=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    mulMleftMright[i][j] = mulMleftMright[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        return mulMleftMright;
    }
}