package by.it.tayanovskii.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {

        double[] array = new double[20];
        int counter = 0;
        int result_length = 0;
        double z;

        for (double x = 5.33; x <= 9 && counter < 20; x += (9 - 5.33) / 20, counter++) {
            z = pow((x * x + 4.5), (double) 1 / 3);
            array[counter] = z;
            if (z > 3.5) result_length++;
        }

        InOut.printArray(array, "A", 5);
        double[] result = new double[result_length];
        double res=1;
        for (int i = 0, j=0 ; i < array.length && j<result_length; i++) {
            if (array[i]>3.5) {
                result[j]= array[i];
                res=res*result[j];
                j++;
            }
        }
        res = pow(res, (double) 1/ result_length);

        InOut.printArray(result, "B", 5);
        System.out.println(res);

    }
}
