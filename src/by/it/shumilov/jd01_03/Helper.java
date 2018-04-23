package by.it.shumilov.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
        return findMM(arr, false);
    }

    static double findMax(double[ ] arr){

        return findMM(arr, true);
    }

    static double findMM(double[ ] arr, boolean vid){
        double m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if((m < arr[i]) == vid) m = arr[i];
        }
        return m;
    }
    public static void sort(double[] arr){
        boolean sort1 = false;
        boolean sort2 = false;
        double buf ;
        int start = 0;
        int finish = arr.length - 1;

        do{
            for (int i = start; i < finish ; i++) {
                if(arr[i]> arr[i+1]) {
                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i+1] = buf;
                    sort1 = true;
                }
            }
            finish--;
            for (int i = finish; start < i; i--) {
                if(arr[i]< arr[i-1]) {
                    buf = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i-1] = buf;
                    sort2 = true;
                }

            }
            start++;

        }while ((start < finish) && (sort1 && sort2));
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
            double[ ] arr = new double[matrix.length];
            double sum;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j]*vector[j];
            }
            arr[i] = sum;

        }
            return  arr;
    }

    static double[][] mul(double[ ][ ] matrix, double[][] vector){
        double[][] arr = new double[matrix.length][vector[0].length];
        double sum;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < vector[0].length; j++) {
                sum = 0;
                for (int k = 0; k < matrix[0].length; k++) {
                    sum += matrix[i][k]*vector[k][j];
                }
                arr[i][j] = sum;
            }

        }
        return  arr;
    }
}
