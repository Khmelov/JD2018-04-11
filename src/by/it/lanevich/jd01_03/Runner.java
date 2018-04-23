package by.it.lanevich.jd01_03;

import java.util.Scanner;

public class Runner {
    /**
     *
     * @param args аргументы - разработанные методы
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        System.out.println("Simple format output");
        InOut.printArray(array);
        System.out.println ("Formated output");
        InOut.printArray(array, "V",3);
        System.out.println();
        double min;
        //min=Helper.findMin(array);
        double max;
        //max=Helper.findMax(array);
        Helper.sort(array);
//double [] mat_mul=Helper.mul(array,)
    }
}
