package by.it.dkruchek.jd01_03;

/**
 * Created by Dmitriy.Kruchek on 4/17/2018.
 */
class InOut {
    /**
     * Parses a string line of doubles into an array
     * @param line the string to be parsed
     * @return array of doubles
     */
    static double[] getArray(String line){
        String[] stringArray = line.split("\\s+");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    /**
     *
     * @param arr the array to print
     */
    static void printArray(double[ ] arr){
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr the array to print
     * @param name name of the array to add
     * @param columnCount number of columns to print
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%-9.4f", i, arr[i]);
            col++;
            if ((0==col%columnCount) || (arr.length - 1 == i)){
                System.out.println();
            }

        }
    }
}
