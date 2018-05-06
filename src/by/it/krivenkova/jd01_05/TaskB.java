package by.it.krivenkova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        double y = 0;
        for (double a = 0; a <= 2; a+=0.2) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.println("При a="+a+" Сумма y ="+y);
        }
    }
    private static void step5() {
        double a = 0, b = 0;
        for (double x = (-6+0.5); x < 2 ; x+= 0.5) {

            if ((-2 < (x/2)) && ((x/2) <= -1)) {
                b = sin(pow(x,2));
            }
            else {
                if (-1 < (x/2) && ((x/2) < 0.2)) {
                    b = cos(pow(x,2));
                }
                else {
                    if (x/2 == 0.2){
                        b = 1/(tan(pow(x,2)));
                    }
                    else {
                        System.out.println("При x/2=" + x / 2 + " вычисления не определены");
                    }
                }
            }

            a = log10(b + 2.74);
            System.out.println("При x/2=" + x / 2 + " a=" + a);
        }
        

    }

}
