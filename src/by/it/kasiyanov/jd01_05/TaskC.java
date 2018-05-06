package by.it.kasiyanov.jd01_05;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        double masA[] = new double[30];
        int i = 0;
        for (double x = 5.33; x < 9; x = x + (9-5.33)/30) {
            masA[i] = cbrt(x * x + 4.5);
            i++;
        }
        System.out.println("Массив A[]");
        for (int j = 0; j < masA.length; j++) {
            if(j%5 == 0 && j != 0){
                System.out.println();
            }
            System.out.printf("A[%3d] = %-10.4g ", j, masA[j]);
        }
        System.out.println();
        System.out.println();

        int n = 0;
        double factum = 1.0;
        for (int k = 0; k < masA.length; k++) {
            if (masA [k] >= 3.5){
                break;
            }
            n++;
        }
        double masB[] = new double[masA.length - n];

        for (int a = 0; a < masB.length; a++) {
            masB[a] = masA[a + n];
            factum = factum * masB[a];
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int b = 0; b < masB.length; b++) {
            if(b%5 == 0 && b != 0){
                System.out.println();
            }
            System.out.printf("B[%3d] = %-10.4g ", b, masB[b]);
        }
        System.out.println();
        System.out.println();
        System.out.println("Среднее геометрическое массива masB = " + exp(Math.log(factum)/masB.length));

    }

}
