package by.it.kashayed.jd01_03;

public class Helper {
    static double findMin(double[]arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min>arr[i]){
                min=arr[i];
            }
        }
        return min;
    }
    static  double findMax(double[]arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]) {
                max=arr[i];
            }
        }
        return max;
    }
    static void sort(double[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j])
                {
                    double x = arr[i];
                    arr[i]=arr[j];
                    arr[j]=x;
                }
            }

        }

    }
    static  double[]mull(double[][]matrix, double[]vector){
        double mull[] = new double[matrix.length];
        if(matrix.length==vector.length){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mull[i]=matrix[j][i]*vector[j];
            }
        }
        }
    return mull;}

}
