package by.it.dkruchek.jd01_03;

public class Runner {
    public static void main(String[] args) {
        String testString = "1 1.3 1.123 5.66 7.4";
        System.out.println("Testing getArray method");
        double[] testArray = InOut.getArray(testString);
        System.out.println("Testing printArray method");
        InOut.printArray(testArray);
        System.out.println("Testing printArray method");
        InOut.printArray(testArray, "testArray", 2);
        System.out.println("Testing findMin method");
        System.out.println(Helper.findMin(testArray));
        System.out.println("Testing findMax method");
        System.out.println(Helper.findMax(testArray));
        System.out.println("Testing mul method: matrix and vector");
        double[][] m1 = {{1,2,3},{1,2,3},{1,2,3}};
        double[] v1 = {1,2,3};
        double[] result1 = Helper.mul(m1, v1);
        InOut.printArray(result1);
        System.out.println("Testing mul method: matrix and matrix");
        double[][] m2 = {{1,2,3},{1,2,3},{1,2,3}};
        double[][] m3 = {{1,2,3},{1,2,3},{1,2,3}};
        double[][] result2 = Helper.mul(m2, m3);
        for (double[] doubles : result2) {
            InOut.printArray(doubles);
        }

    }

}
