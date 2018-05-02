package by.it.dkruchek.jd01_07;

/**
 * Created by Dmitriy.Kruchek on 4/25/2018.
 */
public class Runner {

    public static void main(String[] args) {
        Scalar scalar = new Scalar(7.777);
        Scalar scalar2 = new Scalar(scalar);
        Scalar scalar3 = new Scalar("9.999");
        System.out.println(scalar2);
        System.out.println(scalar3);

        double[] array = {1.1, 3.22, 4.44, 5.0, 6.888};
        Vector vector = new Vector(array);
        Vector vector1  = new Vector(vector);
        Vector vector2= new Vector(vector.toString());
        System.out.println(vector);
        System.out.println(vector1);
        System.out.println(vector2);

        double[][] array1 = {{1,2},{3,4}};
        Matrix matrix = new Matrix(array1);
        Matrix matrix1 = new Matrix(matrix);
        Matrix matrix2 = new Matrix(matrix.toString());
        System.out.println(matrix);
        System.out.println(matrix1);
        System.out.println(matrix2);
    }
}
