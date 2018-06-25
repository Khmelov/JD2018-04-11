package by.it.zaleschonok.jd01_04;

/**
 * Created by Andrey on 16.04.2018.
 */
public class InOut {

    static double[ ] getArray(String line){
        line = line.trim();
        String[] strArr = line.split(" ");
        double[] res=new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
        return res;
    }


    static void printArray(double[ ] arr){
        for (double element : arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i+1)%columnCount==0)
                System.out.println();
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//        printArray(new double[]{1,2,3,4});
//        printArray(new double[]{1,2,3,4,5,6,7,8,9,25},"V",2);
//    }

}
