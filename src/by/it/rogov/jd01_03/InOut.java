package by.it.rogov.jd01_03;



public class InOut {

    /**
     *
     * @param line строка данных
     * @return получаем массив чисел
     */

    static double[] getArray(String line) {

        line = line.trim();
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    /**
     *
     * @param arr одномерный  массив
     */
    static void printArray(double[] arr) {

        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr одномерный массив
     * @param name строковый массив
     * @param columnCount число столбцов
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0) System.out.println();


        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
