package by.it.zaleschonok.jd01_07;


/**
 * Created by Andrey on 04.05.2018.
 */
public class Runner {
    public static void main(String[] args) {
        //Double[] arr = {1.0,2.0,4.0};
        AbstractVar d =new Scalar(3.1415);
        AbstractVar sc = new Scalar(100);
        AbstractVar str1= new Scalar("12345");


        Scalar str2= new Scalar((Scalar)str1);
        System.out.println(d);
        System.out.println(sc);
        System.out.println(str1);
        System.out.println(str2);



        double par[] = {1.,2.,4.};
        Vector v1 = new Vector(par);
        Vector v2 = new Vector(v1);
        Vector v3 = new Vector(v2.toString());
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);


        //Матрицы//
        double matr[][]={{1,2,3,4},{3,4,3,4}};
        Matrix m1 = new Matrix(matr);
        Matrix m2 = new Matrix(m1);
        Matrix m3 = new Matrix(m2.toString());
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        System.out.println("test");

    }
}