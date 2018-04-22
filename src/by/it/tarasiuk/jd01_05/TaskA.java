package by.it.tarasiuk.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }


    private static void step1() {
        double a=756.13;
        double x=0.3;
        double z = cos(pow((x*x +PI/6),5));
        z=z-sqrt(x*pow(a,3));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("z= "+z);
        z=cos(pow((x*x +PI/6),5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
        System.out.println("z= "+z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow((a+b),2))-cbrt(a+1.5)+a*pow(b,5)-b/log(pow(a,2));
        System.out.println("y= "+y);

    }

    private static void step3() {
        double x=12.1;
        double deltaA=3.75;
        double minA=-5;
        double maxA=12;
        double a=minA;
        double f;
        int n=0;
        for (double i=minA; i <=maxA ; i+=deltaA) {
            n++;
        }
        double[][] table=new double[n][2];
        for (int i = 0; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                table[i][0]=a;
                f=pow(E,a*x)-3.45*a;
                table[i][j]=f;
            }
            a+=deltaA;
        }
        System.out.println("a и f");
        for (double[] i:table) {
            for (double j:i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
}
