package by.it.sharin.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a=a+0.2) {
            for (int x = 1; x <= 6; x++) {
                double y=pow(7,a)-cos(x);
                y=y+y;
                System.out.println(y);
            }
        }
    }
}
