package by.it.tayanovskii.jd01_03;

import by.it.tayanovskii.jd01_01.Hello;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        System.out.println("Simple format output");
        InOut.printArray(array);
        System.out.println("Formatted output");
        InOut.printArray(array, "V", 3);
        double max = Helper.findMax(array);
        if (max == Double.MIN_VALUE)
            System.out.println("Массив пустой!!!");
        else
            System.out.println("Максимальный элемент: " + max);

        double min = Helper.findMin(array);

        if (min == Double.MAX_VALUE)
            System.out.println("Массив пустой!!!");
        else
            System.out.println("Минимальный элемент: " + min);

        Helper.sort(array);
        InOut.printArray(array);
    }
}
