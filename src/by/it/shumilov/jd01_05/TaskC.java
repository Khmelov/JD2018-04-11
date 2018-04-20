package by.it.shumilov.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        double a = 5.33;
        double b = 9;
        int n = 28;
        double run = (b-a)/(n-1);
        double[] mas  = new double[n];
        int jump = 0;
        System.out.println("Массив A[]");
        int more = 0;
        for (int i = 0; i < n; i++) {
            mas[i] = pow((pow((i*run+a),2)+4.5),1.0/3.0);
            if (mas[i] <= 3.5) more = i;
            System.out.printf("A[%3d] = %-10.5f ",i,pow((pow((i*run+a),2)+4.5),1.0/3.0));
            jump++;
            if(jump == 5){
                System.out.println();
                jump = 0;
            }
        }
        System.out.println();
        System.out.println("Массив B[] из элементов массива A > 3.5");
        printArray(Arrays.copyOfRange(mas,more+1,n),"A", 5);

        //Arrays.copyOfRange(

/*
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i] );
            if((i+1)%columnCount == 0) System.out.println();

        }*/

        //double z = pow((x*x+4.5),1/3.0);
    }
    static  void  printArray(double[] arr, String name, int columnCount){

        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s[%3d]=%-10.5f ", name, i, arr[i] );
            if((i+1)%columnCount == 0) System.out.println();

        }
        System.out.println();
    }
}
