package by.it.shumilov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String line = scan.nextLine();
        double[] array = InOut.getArray(line);
        System.out.println("Simple format output");
        InOut.printArray(array);
        System.out.println("Formatted output");
        InOut.printArray(array, "arr", 3);
    }
}
