package by.it.krivenkova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar var = new Scalar(7.77);
        Object o = new Scalar(5.55);
        Scalar scalar = new Scalar(8.88);



        System.out.println(var.toString());
        System.out.println(o.toString());
        System.out.println(scalar.toString());
    }
}
