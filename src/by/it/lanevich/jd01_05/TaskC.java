package by.it.lanevich.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {

        double [] A=new double[28];
        int i=0;
        for (double x = 5.33; x <=9 ; x+=0.14) {
            A[i]=cbrt(x*x+4.5);
            System.out.printf("A[%2d]=%g ",i,A[i]);

            if((i+1)%5==0)
                System.out.println();
            i=i+1;

        }
        System.out.println();
        int b=0;
        for (int z = 0; z <28 ; z++) {
            if (A[z]>3.5) b=b+1;
                    }

                    double []B=new double[b];
        int j=0;
        for (int z = 0; z <28 ; z++) {
            if (A[z]>3.5) {B[j]=A[z];j++;}

        }
        for (int z = 0; z <b ; z++) {
            System.out.printf("B[%2d]=%g ",z,B[z]);
            if((z+1)%5==0)
                System.out.println();

        }
    }
}
