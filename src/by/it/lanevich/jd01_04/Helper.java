
package by.it.lanevich.jd01_04;

public class Helper {
    /**
     * @param arr входной одномерный массив
     * @return возвращает минимальное значение массива
     */
    public static double findMin(double[ ] arr){
        double min = arr [0];
        for (double element : arr) {
          if (min>element) min=element;
            }
        System.out.println("Min="+min);
        return min;
    }

    /**
     *
     * @param arr входной одномерный массив
     * @return возвращает максимальное значение массива
     */
    public static double findMax(double[ ] arr){
        double max = arr [0];
        for (double element : arr) {
            if (max<element) max=element;
        }
        System.out.println("Max="+max);
        return max;
    }

    /**
     *
     * @param arr входной массив
     */
    public static void sort(double[ ] arr){
        
      for (int i = 0; i < arr.length-1 ; i++) {
           for (int j = i+1; j < arr.length; j++) {
               if(arr[i]>arr[j])
               {double m=arr[i];
                arr[i]=arr[j];
               arr[j]=m;}}}
            InOut.printArray(arr);


        }

  //  static double[ ] mul(double[ ][ ] matrix, double[ ] vector)
 //   {
//double [] matrix_mul = new double [matrix.length];
      //  for (int i = 0; i < matrix.length; i++) {
     //       for (int j = 0; j < matrix.length; j++) {
     //           matrix_mul[i]=matrix_mul[i]+matrix[i][j]*vector[i];
        //    }
            
      //  }

       // return matrix_mul;
   // }
}
