package by.it.shumilov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar av = new Scalar(7);
        Scalar scalar = new Scalar("1.23");
        Object o = new Scalar(scalar);

        System.out.println(av.toString());
        System.out.println(scalar.toString());
        System.out.println(o.toString());

        AbstractVar av1 = new Vector("{1.0, 2.3, 4.5}");
        System.out.println(av1.toString());
        Vector v  = new Vector(new double[]{11.3, 3.2, 3.2});
        System.out.println(v.toString());
        Object o1 = new Vector(v);
        System.out.println(o1.toString());
    }
}
