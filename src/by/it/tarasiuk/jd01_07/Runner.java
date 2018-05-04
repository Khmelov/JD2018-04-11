package by.it.tarasiuk.jd01_07;

public class Runner {

    public static void main(String[] args) {
        AbstractVar v1=new Scalar(3.14);
        AbstractVar v2=new Vector("{1.23, -4.56, 0.78");
        AbstractVar v3=new Matrix(new double[][]{{1,2,5},{3,4,5}});
        AbstractVar v4=new Matrix("{{1,2,5},{3,4,6}}");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}
