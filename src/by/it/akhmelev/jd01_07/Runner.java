package by.it.akhmelev.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar var=new Scalar("123.456");
        Scalar scalar=new Scalar(8.888);
        Object o=new Scalar(scalar);
        System.out.println(var.toString());
        System.out.println(o.toString());
        System.out.println(scalar.toString());
        AbstractVar vec=new Vector("{1,2,3,4,5}");
        System.out.println(vec);
    }
}
