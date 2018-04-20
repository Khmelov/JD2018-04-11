package by.it.shumilov.jd01_05;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        int a = 103;
        int b = 450;
        Random random = new Random();
        int n = 31;
        int[] masA = new int[n];
        int schet = 0;
        for (int i = 0; i < n; i++) {
            masA[i] = random.nextInt(b - a + 1) + a;
            //проще сделать на Array, но пока не будем забегать вперед
            if (0.1*masA[i] > i) schet++;
        }
        int[] masB = new int[schet];

        for (int i = 0; i < n; i++) {
            if (0.1*masA[i] > i) {
                schet--;
                masB[schet] = masA[i];
            }
        }
        System.out.println("Massiv M (index to rows)");

        printArrayPsevdo(masA,"M", 5);
        System.out.println();

        //sort B!!!!!!
        System.out.println("Massiv B (index to cols)");
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


    }
    static  void  printArray(double[] arr, String name, int columnCount){
        double umn = 1;
        for (int i = 0; i < arr.length; i++) {
            umn = umn*arr[i];
            System.out.printf("%s[%3d]=%-10.5f ", name, i, arr[i] );
            if((i+1)%columnCount == 0) System.out.println();

        }
        System.out.println();
        System.out.println("Среднее геометрическое: " + pow(umn,1.0/arr.length));
    }

    static  void  printArrayPsevdo(int[] arr, String name, int columnCount){
        int plus = 0;
        System.out.println("╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗");
        if (arr.length%columnCount != 0) plus = columnCount - arr.length%columnCount;
        for (int i = 0; i < arr.length; i++) {

            System.out.printf("║ %s[%2d]=%3d ", name, i, arr[i] );

            if((i+1)%columnCount == 0){
                System.out.println("║");
                if(arr.length-i+plus >columnCount ){
                    System.out.println("╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣");
                }
            }


        }
        for (int i = 0; i < plus; i++) {
            System.out.print("║           ");
        }
        if(plus>0) System.out.println("║");
        System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");

    }
}
