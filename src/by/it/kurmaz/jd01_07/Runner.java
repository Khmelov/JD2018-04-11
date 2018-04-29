package by.it.kurmaz.jd01_07;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Making scalar:");
        Scalar s1 = new Scalar(3.1);
        Scalar s2 = new Scalar(s1);
        Scalar s3 = new Scalar("5.1");
        System.out.println(s1.toString() + " " + s2.toString() + " " + s3.toString());

        System.out.println("Making vector:");
        Vector v1 = new Vector(new double[]{1.2, 1.5, 1.6});
        Vector v2 = new Vector(v1);
        Vector v3 = new Vector ("{1.7, 1.8, 1.9}");
        System.out.println(v1.toString() + " " + v2.toString() + " " + v3.toString());

        System.out.println("Making matrix:");
        Matrix m1 = new Matrix(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}});
        Matrix m2 = new Matrix (m1);
        Matrix m3 = new Matrix ("{{1.5, 2.7, 3.6}, {4.1, 5.3, 6.8}, {7.1, 8.2, 9.3}}");
        System.out.println(m1.toString() + " " + m2.toString() + " " + m3.toString());
    }
}
