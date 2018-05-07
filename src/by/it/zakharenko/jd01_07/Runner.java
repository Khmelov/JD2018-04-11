package by.it.zakharenko.jd01_07;

public class Runner {

    public static void main(String[] args) {

        AbstractVar var1 = new Scalar("123.456");  //для строки
        Scalar scalar = new Scalar(9.999);  //для вещественного числа
        Object o1 = new Scalar(scalar);    //для такого же числа

        System.out.println(var1.toString());
        System.out.println(o1.toString());
        System.out.println(scalar.toString());


        AbstractVar var2 = new Vector("{1.0, 2.0, 4.0}"); //для строки
        Vector vector = new Vector(new double[]{1, 2, 4});  //для массива
        Object o2 = new Vector(vector); //для такого же числа

        System.out.println(var2.toString());
        System.out.println(o2.toString());
        System.out.println(vector.toString());

        AbstractVar var3 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}"); //для строки
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});  //для массива
        Object o3 = new Matrix(matrix); //для такого же числа

        System.out.println(var3.toString());
        System.out.println(o3.toString());
        System.out.println(matrix.toString());

    }
}