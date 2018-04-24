package by.it.kasiyanov.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7,a) - cos(x);
            }
            System.out.printf("При a=%-5.2fСумма y =%g%n", a, y);
        }
    }

    private static void step2() {
        double bet = 0;
        double alph;
        for (double x = -5.5; x < 2 ; x = x + 0.5) {
            if (x/2 > -2 && x/2 <= -1){
                bet = sin(x * x);
                alph = log10(abs(bet + 2.74));
                System.out.printf("При x/2=%-5.2f alph =%g%n", x/2, alph);
            }
            else if (x/2 > -1 && x/2 < 0.2){
                bet = cos(x * x);
                alph = log10(abs(bet + 2.74));
                System.out.printf("При x/2=%-5.2f alph =%g%n", x/2, alph);
            }
            else if (x/2 == 0.2){
                bet = 1 / tan(x * x);
                alph = log10(abs(bet + 2.74));
                System.out.printf("При x/2=%-5.2f alph =%g%n", x/2, alph);
            }
            else {
                System.out.printf("При x/2=%-5.2f вычисления не определены%n", x/2);
            }
        }
    }

}
