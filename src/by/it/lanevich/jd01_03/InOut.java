
package by.it.lanevich.jd01_03;

public class InOut {
    /**
     *
     * @param line входная строка элементов массива
     * @return возвращает числовой массив
     */
    public static double[ ] getArray(String line){
       String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i=0; i<strArr.length; i++){
            res[i]=Double.parseDouble(strArr[i]);
        }

                return res;

    }

    /**
     * @param arr одномерный массив
     */
    public static void printArray (double[] arr) {
        for (double element : arr) {
            System.out.print(element+ " ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr одномерный массив
     * @param name имя матрицы
     * @param colomnCount число столбцов при выводе на экран
     */
    public static void printArray (double[] arr, String name, int colomnCount){

        for (int i=0; i<arr.length; i++){
            System.out.printf("%s[% -3d]=%-10.4f ",name, i, arr[i]);
            if((i+1)%colomnCount==0)
                System.out.println();
        }
    }

}
