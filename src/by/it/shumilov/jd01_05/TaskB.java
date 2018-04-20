package by.it.shumilov.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        for (double i = -5.5; i < 2 ; i+=0.5) {
            double x = i/2;
            double b;
            if(x > -2 &&  x<=-1) b = sin(i*i);
            else if (x > -1 &&  x < 0.2) b = cos(i*i);
            else if(x == 0.2) b = atan(x*x);
            else {
                System.out.printf("При x/2=%3.2f вычисления не определены\n",x);
                continue;
            }
            double a = log10(abs(b+2.74));
            System.out.printf("При x/2=%3.2f a=%g\n",x,a);
        }
    }

    private static void step1() {



        for (double a=0; a<=2; a+=0.2){
            double f = 0;
            for (int i = 1; i <= 6; i++) {

            f += pow(7,a)-cos(i);}
            System.out.printf("For a=%6.2f F=%g\n",a,f);


        }



    }

}
