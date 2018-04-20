package by.it.tarasiuk.jd01_03;

public class InOut {
    /**
     *
     * @param line исходная строка, вводимая в командную строку пользователем
     * @return возвращает одномерный массив типа double
     */
    static double[] getArray(String line){
        line = line.trim();
        String[] strArr = line.split(" ");
        double[] res=new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }

        return res;
    }

    /**
     *
     * @param arr передается одномерный массив типа double
     */
    static void printArray(double[] arr) {
        for (double element:arr
                ) {
            System.out.print(element + " ");


        }
        System.out.println();
    }

    /**
     *
     * @param arr передается одномерный массив типа double
     * @param name передает строковое имя аргумента
     * @param columnCount устанавливает кол-во столбцов матрицы
     */

    static void printArray(double[] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i+1)%columnCount==0)
                System.out.println();
        }
        System.out.println();

    }

}

