package by.it.shumilov.jd01_04;

class InOut {
    static double[] getArray(String line){
        line = line.trim();
        String[] arrStr = line.split(" ");
        double[] arrDouble = new double[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arrDouble[i] = Double.valueOf(arrStr[i]);
        }
        return arrDouble;
    }
    static  void printArray(double[] arr){
        for (double ar : arr) {
            System.out.print(String.valueOf(ar) + " ");
        }
        System.out.print("/n");
    }
    static  void  printArray(double[] arr, String name, int columnCount){

        for (int i = 0; i < arr.length; i++) {

            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i] );
            if((i+1)%columnCount == 0) System.out.println();

        }
        System.out.println();
    }
 }
