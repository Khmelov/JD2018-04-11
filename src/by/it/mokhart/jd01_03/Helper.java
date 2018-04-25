package by.it.mokhart.jd01_03;

public class Helper {
    static double findMax(double[] arr) {
        double max = arr[0];
        for (double elem : arr) {
            if (max < elem)
                max = elem;
        }
        System.out.printf("%.2f \n", max);
        return max;
    }

    static double findMin(double[] arr) {
        double min = arr[0];
        for (double elem : arr) {
            if (min > elem)
                min = elem;
        }
        System.out.printf("%.2f \n", min);
        return min;
    }

    static void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int sign = i + 1; sign < arr.length; sign++) {
                if (arr[sign] < arr[i]) {
                    double temp;
                    temp = arr[i];
                    arr[i] = arr[sign];
                    arr[sign] = temp;
                }
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static double[][] createMatrix() {
        double matrix[][] = new double[5][5];
        System.out.println("Matrix");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * 20) + 1;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    static double[] vector() {
        double vector[] = new double[5];
        System.out.println("Vector");
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 20);
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        return vector;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] q = new double[matrix.length];
        System.out.println("Matrix x Vector");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                q[i] = q[i] + matrix[i][j] * vector[j];
            }
            System.out.print(q[i] + " ");
        }
        return q;
    }
}
