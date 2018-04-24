package by.it.shumilov.jd01_04;



import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.*;

public class TaskC {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        buildOneDimArray(sc.nextLine());




    }

    static void buildOneDimArray(String line){
        double[] mas = InOut.getArray(line);
        InOut.printArray(mas, "V", 5);

        double first  = mas [0];
        double last  = mas [mas.length-1];
        mergeSort(mas);
        InOut.printArray(mas, "V", 4);
        System.out.println("Index of first element=" + binarySearch(mas,first));
        System.out.println("Index of last element=" + + binarySearch(mas,last));

    }

    static void mergeSort (double[ ] array){

        double[] ar = mergeSort(array, 0, array.length -1 );
        for (int i = 0; i < ar.length; i++) {
            array[i] = ar[i];
        }

    }

    private static double[] mergeSort(double[ ] array, int left, int right) {

        if(left == right) return  array;
        int mid = (left + right)/2;


        double[] ar1 = mergeSort(Arrays.copyOfRange(array, left, mid + 1),left, mid);

        double[] ar2 =mergeSort(copyOfRange(array, mid +1, right +1),0, right -mid -1);
        double[] res = merge( ar1,ar2);
        return  res;//(Arrays.copyOfRange(array,left,mid + 1), Arrays.copyOfRange(array,mid+1,right +1));
    }

    private static double[] merge(double[] part1,double[] part2) {

        double[] buf = new double[part1.length + part2.length];
        int i = 0,j = 0;
        for (int k = 0; k < buf.length; k++) {
            if(i == part1.length){
                buf[k] = part2[j];
                j++;
                continue;
            }
            if(j == part2.length ){
                buf[k] = part1[i];
                i++;
                continue;
            }

            if( (part1[i] > part2[j])){
                buf[k] = part2[j];
                j++;
            }
            else {
                buf[k] = part1[i];
                i++;
            }

        }

        return buf;
    }


    static int binarySearch(double[ ] array, double value){
        int mid ;

        int left = 0;
        int right = array.length-1;

        while (left<right){
            mid  = (left + right)/2 ;
            if (value == array[mid]) return  mid;
            else if (value > array[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return  left;

    }


}




