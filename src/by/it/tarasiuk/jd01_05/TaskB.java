package by.it.tarasiuk.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <=2 ; a+=0.2) {
            double y =0;
            for (int x = 1; x <=6 ; x++) {
                y=y+pow(7,a)-cos(x);
            }
            System.out.printf("При a=%-3.1f\ty=%-10.5f\n",a,y);
        }
    }
    private static void step2() {
        double a,b;
        String condition;
        for (double x = -6+0.5; x <2 ; x+=0.5) {
            if (-2<(x/2)&&(x/2)<=-1) { b=sin(pow(x,2)); condition = "sin(x^2)";}
            else if (-1<x/2&&x/2<0.2) { b=cos(pow(x,2)); condition = "cos(x^2)";}
            else if (x/2==0.2) { b=1/tan(pow(x,2)); condition = "ctg(x^2)";}
            else {System.out.printf("При x=%-3.1f Нет решения\n",x); continue;}
            a=log10(abs(b+2.74));
            System.out.printf("При x=%-3.1f\tb=%-8s=%e\ta=%e\n",x,condition,b,a);
        }
    }
}
