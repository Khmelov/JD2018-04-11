package by.it.kurmaz.jd01_05;
import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {

        double[] array = new double[20];
        double delta = (9.0-5.33)/(20);
        int counter = 0;
        int newArrayCounter = 0;
        System.out.println("Массив А[]");
        for (double x = 5.33; x <=9 ; x+=delta) {
            double z = pow((x*x+4.5), (double)1/3);
            array[counter] = z;
            System.out.printf("A[ %-2d] = %-10.5f", counter, z);
            counter++;
            if (z > 3.5)
                newArrayCounter++;
            if ((counter+1)%5 == 0)
                System.out.println();
        }
        double[] newArray = new double[newArrayCounter];
        newArrayCounter = 0;
        double sum = 0;
        for (double a: array) {
            if (a > 3.5) {
                newArray[newArrayCounter] = a;
                sum+=a;
                newArrayCounter++;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Массив В[] из элементов массива A > 3.5");
        for (int i = 0; i < newArray.length; i++) {
            System.out.printf("В[ %-2d] = %-10.5f", i, newArray[i]);
            if ((i+1)%5 == 0)
                System.out.println();
        }
        System.out.println();
        System.out.printf("Average = %.4f\n", sum/newArrayCounter);
    }
}
