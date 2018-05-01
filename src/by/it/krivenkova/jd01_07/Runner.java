package by.it.krivenkova.jd01_07;

public class Runner {
    public static void main(String[] args) {
        AbstractVar var = new Scalar(7.77);
        Object o = new Scalar(5.55);
        Scalar scalar = new Scalar(8.88);

        System.out.println(var.toString());
        System.out.println(o.toString());
        System.out.println(scalar.toString());


        double[] vect1={1.0, 2.0, 3.0};
        AbstractVar v1=new Vector(vect1);
        System.out.println("из массива double : "+v1);
        double[] vect2={1.0, 2.0, 4.0};
        v1= new Vector(vect2);
        AbstractVar v2=v1;
        System.out.println("из другого вектора : "+v2);
        String vect3="1.0, 2.0, 5.0";
        AbstractVar v3= new Vector(vect3);
        System.out.println("из строки : "+v3);
    }
}
