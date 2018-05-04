package by.it.kasiyanov.jd01_08;

public class Runner {
    public static void main(String[] args) {
        AbstractVar v1 = new Scalar(3.1415);
        AbstractVar v2 = new Vector(new double[]{1,2,3});
        AbstractVar v3 = new Vector(new String("1,2,3"));
        AbstractVar v4 = new Matrix(new double[][]{{1,2},{3,4}});
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}
