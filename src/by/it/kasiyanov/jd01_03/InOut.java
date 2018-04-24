package by.it.kasiyanov.jd01_03;


public class InOut {

     /**
     *Используется для преобразования считанной из консоли строки
     *в одномерный мвссив чисел с плавающей запятой
     * @param line входная строка
     * @return res[] одномерный мвссив чисел на выходе
     */
    static double[] getArray(String line) {
        line.trim();
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

     /**
     *Выводит полученный одномерный массив чисел в консоль
     *одной строкой через пробел
     * @param arr входной одномерный массиве чисел
     */
    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
    }

    /**
     *Выводит полученный одномерный массив чисел в консоль
     *строками по заданному количеству значений, с указанием
     *имени значения, в виде - "[имя]=значение"
     * @param arr входной одномерный массиве чисел
     * @param name входное имя, которое будет выведено перед каждым
     * значением массива
     * @param columnCount входное количество значений (колонок) для
     * вывода массива
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 ){
                System.out.println();
            }
        }
        System.out.println();
    }


}
