package by.it.kurmaz.jd01_03;

class InOut {
    /**
     *
     * @param line - входящая строка
     * @return - возвращает массив, преобразованный из строки
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] values = line.split(" ");
        double[] array = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            array[i] = Double.parseDouble(values[i]);
        }
        return array;
    }

    /**
     *
     * @param arr - входящий массив
     */
    static void printArray(double [] arr) {
        for (double a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr - входящий массив
     * @param name - имя массива, используется при печати
     * @param columnCount - кол-во столбцов при печати массива
     */

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%-9.4f ", i, arr[i]);
            if ((i+1)%columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }

    /**
     *
     * @param matrix - исходная матрица
     * @param columnCount - количество столбцов для вывода в печать
     */

    static void printMatrix(double[][] matrix, int columnCount) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%-7.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
