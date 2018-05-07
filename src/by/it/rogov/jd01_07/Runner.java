package by.it.rogov.jd01_07;

public class Runner {

    public static void main(String[] args) {

        AbstractVar v1 = new Scalar(3.1415);
        AbstractVar v2 = new Scalar("3.1415");
        Scalar v3 = new Scalar((Scalar) v2);
        AbstractVar v4 = new Vector("2,3,5,6,8");
        AbstractVar v9 = new Matrix("{{1,2},{3,4}}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v9);

    }
}
