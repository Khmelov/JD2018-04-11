package by.it.lanevich.calc2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test02_04 {

    @Test(timeout = 5000)
    public void TaskA() throws Exception{
       Parser parser = new Parser();
       //выражения из задания
        assertEquals("ERROR",7.3,Double.parseDouble(parser.calc("A=2+5.3").toString()),1e-20);
        assertEquals("ERROR",25.55,Double.parseDouble(parser.calc("B=A*3.5").toString()),1e-20);
        assertEquals("ERROR",25,Double.parseDouble(parser.calc("B1=B+0.11*-5").toString()),1e-20);
        assertEquals("ERROR",2.65,Double.parseDouble(parser.calc("B2=A/2-1").toString()),1e-20);
       //операция сложение скаляр+скаляр
        assertEquals("ERROR",4.6,Double.parseDouble(parser.calc("C1=1.2+3.4").toString()),1e-20);
        assertEquals("ERROR",-2.2,Double.parseDouble(parser.calc("C1=1.2+-3.4").toString()),1e-20);
       //операция вычитание скаляр-скаляр
        assertEquals("ERROR",-2.2,Double.parseDouble(parser.calc("C2=1.2-3.4").toString()),1e-20);
        assertEquals("ERROR",4.6,Double.parseDouble(parser.calc("C2=1.2--3.4").toString()),1e-20);
       //операция произведение скаляр*скаляр
        assertEquals("ERROR",4.08,Double.parseDouble(parser.calc("C3=1.2*3.4").toString()),1e-20);
        assertEquals("ERROR",-4.08,Double.parseDouble(parser.calc("C3=1.2*-3.4").toString()),1e-20);
        assertEquals("ERROR",4.08,Double.parseDouble(parser.calc("-1.2*-3.4").toString()),1e-20);
       //операция деление скаляр/скаляр
        assertEquals("ERROR",0.48,Double.parseDouble(parser.calc("C4=1.2/2.5").toString()),1e-20);
        assertEquals("ERROR",-0.48,Double.parseDouble(parser.calc("C4=1.2/-2.5").toString()),1e-20);
        assertEquals("ERROR",-0.48,Double.parseDouble(parser.calc("-1.2/2.5").toString()),1e-20);
        }


    @Test(timeout = 5000)
    public void TaskB() throws Exception{
        Parser parser = new Parser();
        //выражения из задания
        assertEquals("ERROR",40.15,Double.parseDouble(parser.calc("C=B+(A*2)").toString()),1e-20);
        assertEquals("ERROR",10,Double.parseDouble(parser.calc("D=((C-0.15)-20)/(7-5)").toString()),1e-20);
        assertEquals("ERROR","{10.0, 15.0}", parser.calc("E={2,3}*(D/2)").toString());
        //операция сложение вектор+скаляр
        assertEquals("ERROR","{4.0, 5.0}", parser.calc("F={1,2}+3").toString());
        assertEquals("ERROR","{-2.0, -1.0}", parser.calc("{1,2}+-3").toString());
        //операция сложение вектор+вектор
        assertEquals("ERROR","{4.0, 6.0}", parser.calc("F1={1,2}+{3,4}").toString());
        assertEquals("ERROR","{-2.0, 6.0}", parser.calc("{1,2}+{-3,4}").toString());
        //операция вычитание вектор-скаляр
        assertEquals("ERROR","{-2.0, -1.0}", parser.calc("F2={1,2}-3").toString());
        assertEquals("ERROR","{-4.0, -5.0}", parser.calc("-3-{1,2}").toString());
        //операция вычитание вектор-вектор
        assertEquals("ERROR","{-2.0, -2.0}", parser.calc("F3={1,2}-{3,4}").toString());
        assertEquals("ERROR","{8.0, 2.0}", parser.calc("{5,6}-{-3,4}").toString());
        //операция произведение вектор*скаляр
        assertEquals("ERROR","{3.0, 6.0}", parser.calc("F4={1,2}*3").toString());
        assertEquals("ERROR","{-3.0, -6.0}", parser.calc("-3*{1,2}").toString());
        //операция произведение вектор*вектор
        assertEquals("ERROR","11.0", parser.calc("F5={1,2}*{3,4}").toString());
        assertEquals("ERROR","39.0", parser.calc("{-5,6}*{-3,4}").toString());
        //операция деление вектор/скаляр
        assertEquals("ERROR","{0.25, 0.5}", parser.calc("F6={1,2}/4").toString());
        assertEquals("ERROR","{-2.0, -3.0}", parser.calc("{6,9}/-3").toString());
    }

    @Test(timeout = 5000)
    public void TaskC() throws Exception{
        Parser parser = new Parser();
        //операция сложение матрица+скаляр
        assertEquals("ERROR","{{6.0, 7.0}, {8.0, 9.0}}", parser.calc("G={{1,2},{3,4}}+5").toString());
        assertEquals("ERROR","{{6.125, 7.125}, {8.125, 9.125}}", parser.calc("5.125+{{1,2},{3,4}}").toString());
        //операция сложение матрица+матрица
        assertEquals("ERROR","{{6.0, 8.0}, {10.0, 12.0}}", parser.calc("G1={{1,2},{3,4}}+{{5,6},{7,8}}").toString());
        assertEquals("ERROR","{{-4.0, 4.0}, {-10.0, 12.0}}", parser.calc("{{1,-2},{-3,4}}+{{-5,6},{-7,8}}").toString());
        //операция вычитание матрица-скаляр
        assertEquals("ERROR","{{-4.0, -3.0}, {-2.0, -1.0}}", parser.calc("G2={{1,2},{3,4}}-5").toString());
        assertEquals("ERROR","{{4.25, 3.25}, {2.25, 1.25}}", parser.calc("5.25-{{1,2},{3,4}}").toString());
        //операция вычитание матрица-матрица
        assertEquals("ERROR","{{-4.0, -4.0}, {-4.0, -4.0}}", parser.calc("G3={{1,2},{3,4}}-{{5,6},{7,8}}").toString());
        assertEquals("ERROR","{{6.0, -8.0}, {4.0, -4.0}}", parser.calc("{{1,-2},{-3,4}}-{{-5,6},{-7,8}}").toString());
        //операция произведение матрица*скаляр
        assertEquals("ERROR","{{5.0, 10.0}, {15.0, 20.0}}", parser.calc("G4={{1,2},{3,4}}*5").toString());
        assertEquals("ERROR","{{5.25, -10.5}, {-15.75, 21.0}}", parser.calc("5.25*{{1,-2},{-3,4}}").toString());
        //операция произведение матрица*вектор
        assertEquals("ERROR","{17.0, 39.0}", parser.calc("G5={{1,2},{3,4}}*{5,6}").toString());
        assertEquals("ERROR","{-17.0, -39.0}", parser.calc("{{1,-2},{3,-4}}*{-5,6}").toString());
        //операция произведение матрица*матрица
        assertEquals("ERROR","{{19.0, 22.0}, {43.0, 50.0}}", parser.calc("G6={{1,2},{3,4}}*{{5,6},{7,8}}").toString());
        assertEquals("ERROR","{{8.75, -9.75}, {-12.25, 13.25}}", parser.calc("{{1,-2},{-3,4}}*{{-5.25,6.25},{-7,8}}").toString());
        //операция деление матрица/скаляр
        assertEquals("ERROR","{{0.2, 0.4}, {0.6, 0.8}}", parser.calc("G7={{1,2},{3,4}}/5").toString());
        assertEquals("ERROR","{{0.1, 0.2}, {0.3, 0.4}}", parser.calc("{{1,2},{3,4}}/10").toString());

        //создание переменной типа Scalar
        Scalar sc1 = new Scalar(1.2);
        assertEquals(sc1.getValue(), 1.2, 0.0);
        assertEquals(sc1.toString(), "1.2");

        Scalar sc2 = new Scalar(sc1);
        assertEquals(sc2.toString(), "1.2");

        Scalar sc3 = new Scalar("3.4");
        assertEquals(sc3.toString(), "3.4");

        //создание переменной типа Vector
        Vector v1 = new Vector(new double[]{1.2, -3});
        assertEquals(v1.toString(), "{1.2, -3.0}");

        Vector v2 = new Vector(v1);
        assertEquals(v2.toString(), "{1.2, -3.0}");

        Vector v3 = new Vector("{4.5, -6}");
        assertEquals(v3.toString(), "{4.5, -6.0}");


        //создание переменной типа Matrix
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3},{4.0, 5.0, 6.0},{7, 8.0, 9.0}});
        assertEquals(m1.toString(), "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}");

        Matrix m2 = new Matrix(m1);
        assertEquals(m2.toString(), "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}");

        Matrix m3 = new Matrix("{{1, 2, 3},{4.0, 5.0, 6.0},{7, 8.0, 9.0}}");
        assertEquals(m3.toString(), "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}");

    }
}