package by.it.kurmaz.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        double min;
        if (arr.length == 0)
            return Double.MIN_VALUE;
        else {
            min = arr[0];
            for (double a: arr) {
                if (a < min)
                    min = a;
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max;
        if (arr.length == 0)
            return Double.MAX_VALUE;
        else {
            max = arr[0];
            for (double a: arr) {
                if (a > max)
                    max = a;
            }
        }
        return max;
    }

    static void sort (double[] arr) {
        int counter = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < counter; j++) {
                if (arr[j] > arr[j+1]) {
                    double buff = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = buff;
                }
            }
            counter--;
        }
    }

    static double[] mul (double[][] matrix, double[] vector) {
        double[] newMatrix = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++ ) {
            for (int j = 0; j < vector.length; j++) {
                newMatrix[i] += matrix[i][j] * vector[j];
            }
        }
        return newMatrix;
    }

    static double[][] mul (double[][] matrixLeft, double[][] matrixRight) {
        double[][] newMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newMatrix[i][j] += matrixLeft[i][k]* matrixRight[k][j];
                }
            }
        }
        return newMatrix;
    }
}
