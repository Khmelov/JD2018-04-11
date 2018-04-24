package by.it.krivenkova.jd01_04;

import java.util.Scanner;

public class TaskA {
    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        /*

        формирует из строки line массив вещественных чисел,
(можно скопировать для этого класс InOut, написанный в jd01_03 Задание A)
 выводит в 5 колонок этот массив с названием V и индексами (тоже InOut),
например V[ 1 ]=12,234 V[ 2 ]=2,345 и т.д.
 сортирует этот массив по возрастанию (см. Helper.sort в jd01_03 Задание B)
 еще раз выводит его (см. InOut), но уже в 4 колонки с заголовками и тем же названием
 выполняет вычисление новых (после сортировки) индексов первого и последнего элемента
исходного массива и печатает их в виде:
Index of first element=2
Index of last element=7
         */
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
       String line = scanner.nextLine();
        buildOneDimArray(line);
    }
}
