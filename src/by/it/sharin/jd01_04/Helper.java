package by.it.sharin.jd01_04;

public class Helper {
    static double findMin(double[ ] arr) {
        if (0==arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min=arr[0];
            for (double element : arr) {
                if (min>element) min=element;
            }
            return min;
        }
    }
    static double findMax(double[ ] arr) {
        if (0==arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max=arr[0];
            for (double element : arr) {
                if (max<element) max=element;
            }
            return max;
        }
    }
    static void sort(double[ ] arr) {
        boolean swap;
        int last=arr.length-1;
        do {
            swap=false;
            for (int j = 0; j < last; j++) {
                if (arr[j]>arr[j+1]) {
                    double buffer=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=buffer;
                    swap=true;
                }
            }
            last--;
        }
        while (swap);
    }
    static double[] sort(double[ ] arr, boolean upDirection) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ((upDirection && arr[i]>arr[j]) || (!upDirection && arr[i]<arr[j])) {
                    double element=arr[i];
                    arr[i]=arr[j];
                    arr[j]=element;
                }
            }
        }
        return arr;
    }
}
