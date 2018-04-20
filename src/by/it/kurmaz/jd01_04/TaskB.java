package by.it.kurmaz.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("How many people?");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String buf = scanner.nextLine();

        String[] names = new String[n];
        for (int i = 0; i < names.length; i++) {
            System.out.println("Enter a name for person # " + i);
            names[i] = scanner.nextLine();
        }

        int[][] salary = new int[names.length][4];


        for (int i = 0; i < names.length; i++) {
            System.out.println("Enter a salary for "+names[i]);
            salary[i] = getIntArray(scanner.nextLine());
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Фамилия  Квартал1  Квартал2  Квартал3  Квартал4  Итого ");
        System.out.println("-------------------------------------------------------");

        int bigSum = 0;
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%7s: ", names[i]);
            int sum = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d", salary[i][j]);
                sum+= salary[i][j];
            }
            System.out.printf("%-6d", sum);
            System.out.println();
            bigSum+=sum;
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("Итого    "+bigSum);
        System.out.println();
        double av = (double)bigSum/(double)names.length/4;
        System.out.printf("Средняя  %.4f", av);

    }

    static int[] getIntArray(String line) {
        line = line.trim();
        String[] values = line.split(" ");
        int[] array = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }
        return array;
    }


}
