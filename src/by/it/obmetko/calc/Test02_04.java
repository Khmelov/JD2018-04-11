package by.it.obmetko.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test02_04 {
    @Test(timeout = 1500)
    public void scalar() throws Exception {
        Parser parser = new Parser();
        assertEquals(parser.calc("A=2+5.3").toString(), "7.3");
        assertEquals(parser.calc("B=A*3.5").toString(), "25.55");
        assertEquals(parser.calc("B1=B+0.11*-5").toString(), "25.0");
        assertEquals(parser.calc("B2=A/2-1").toString(), "2.65");
        //доп проверка
        assertEquals(parser.calc("3/-.3").toString(), "-10.0");
        assertEquals(parser.calc("2/.5").toString(), "4.0");
        assertEquals(parser.calc("2+-.5").toString(), "1.5");
        assertEquals(parser.calc("2+-6.5").toString(), "-4.5");
        assertEquals(parser.calc("-2+-8").toString(), "-10.0");
        assertEquals(parser.calc("A=5-3").toString(), "2.0");
        assertEquals(parser.calc("-5*-6").toString(), "30.0");
        assertEquals(parser.calc("2*-.3").toString(), "-0.6");
        assertEquals(parser.calc("2*.5").toString(), "1.0");

    }

    @Test(timeout = 1500)
    public void vector() throws Exception {
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("C=B+(A*2)").toString(), "40.15");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(), "10.0");
        assertEquals(parser.calc("E={2,3}*(D/2)").toString(), "{10.0, 15.0}");
        //доп проверки
        assertEquals(parser.calc("{2,-3,4}+{5,6,-7}").toString(), "{7.0, 3.0, -3.0}");
        assertEquals(parser.calc("{2,-3,4}-{5,6,-7}").toString(), "{-3.0, -9.0, 11.0}");
        assertEquals(parser.calc("{2,3,4}*{5,6,7}").toString(), "56.0");
        assertEquals(parser.calc("{2,-3,4}*{5,6,-7}").toString(), "-36.0");
        assertEquals(parser.calc("{2,2,-4}/.5").toString(), "{4.0, 4.0, -8.0}");

    }

    @Test(timeout = 1500)
    public void matrix() throws Exception {
        Parser parser = new Parser();
        parser.calc("M1={{2,3,4},{5,6,7}}");
        parser.calc("M2={{2,3,11},{12,5,14}}");
        parser.calc("M4={{2,3},{4,5}}");
        parser.calc("M5={{2,3},{4,5}}");
        //операции типа "матрица + матрица"
        assertEquals(parser.calc("M3=M1+M2").toString(),
                "{{4.0, 6.0, 15.0}, {17.0, 11.0, 21.0}}");
        assertEquals(parser.calc("{{1,-2},{-8,3}}+{{1,2},{8,-3}}").toString(),
                "{{2.0, 0.0}, {0.0, 0.0}}");
        //операции типа "матрица * матрица"
        assertEquals(parser.calc("M6=M4*M5").toString(),
                "{{16.0, 21.0}, {28.0, 37.0}}");
        assertEquals(parser.calc("{{1,-2},{-8,3}}*{{1,2},{8,-3}}").toString(), "{{-15.0, 8.0}, {16.0, -25.0}}");
        //операции типа "матрица - матрица"
        assertEquals(parser.calc("M7=M6-M4").toString(),
                "{{14.0, 18.0}, {24.0, 32.0}}");
        assertEquals(parser.calc("{{1,-2},{-8,3}}-{{1,2},{8,-3}}").toString(),
                "{{0.0, -4.0}, {-16.0, 6.0}}");
        //операции типа "скаляр + матрица", "матрица + скаляр"
        assertEquals(parser.calc("5+{{1,10},{6,3}}").toString(),
                "{{6.0, 15.0}, {11.0, 8.0}}");
        assertEquals(parser.calc("{{-1,10},{6,-33}}+10").toString()
                , "{{9.0, 20.0}, {16.0, -23.0}}");
        //операции типа "скаляр - матрица", "матрица - скаляр"
        assertEquals(parser.calc("5-{{1,10},{6,3}}").toString(),
                "{{-6.0, -15.0}, {-11.0, -8.0}}");
        assertEquals(parser.calc("{{-1,10},{6,-33}}-10").toString(),
                "{{-11.0, 0.0}, {-4.0, -43.0}}");
        //операция типа "матрица / скаляр"
        assertEquals(parser.calc("{{-9,18},{6,-33}}/3").toString(),
                "{{-3.0, 6.0}, {2.0, -11.0}}");
        //операции типа "матрица * вектор"
        assertEquals(parser.calc("{{1,2},{8,3}}*{1,2}").toString(),
                "{5.0, 14.0}");
        assertEquals(parser.calc("{{1,-2},{8,-3}}*{1,-2}").toString(),
                "{5.0, 14.0}");
        //проверка задания  со скобками
        assertEquals(parser.calc("{{1,2},{8,-4}}/2*{1,2}*10-{1,-3}").toString(), "{24.0, 3.0}");
        assertEquals(parser.calc("{{1,2},{8,3}}*{1,2}-{1,2}*10").toString(), "{-5.0, -6.0}");
        assertEquals(parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}+{{1,2},{8,3}}").toString(), "{{18.0, 10.0}, {40.0, 28.0}}");
    }



    @Test (timeout = 1500)
    public void input() throws Exception{
        Parser parser = new Parser();
        //проверка работы конструкторов класса Scalar
        //создание переменной типа Scalar на основе числа
        Scalar sc1 = new Scalar(5.2);
        assertEquals(sc1.getValue(), 5.2, 0.0);
        assertEquals(sc1.toString(), "5.2");

        //создание переменной типа Scalar на основе объекта Scalar
        Scalar sc2 = new Scalar(sc1);
        assertEquals(sc2.toString(), "5.2");

        //создание переменной типа Scalar на основе строки
        Scalar sc3 = new Scalar("8.2");
        assertEquals(sc3.toString(), "8.2");
        //проверка работы конструкторов класса Vector
        //создание переменной типа Vector на основе массива
        Vector v1 = new Vector(new double[]{5.2, -3});
        assertEquals(v1.toString(), "{5.2, -3.0}");

        //создание переменной типа Vector на основе объекта Vector
        Vector v2 = new Vector(v1);
        assertEquals(v2.toString(), "{5.2, -3.0}");

        //создание переменной типа Vector на основе строки
        Vector v3 = new Vector("{5.2, -3}");
        assertEquals(v3.toString(), "{5.2, -3.0}");

        //проверка работы конструкторов класса Matrix
        //создание переменной типа Matrix на основе многомерного массива
        Matrix m1 = new Matrix(new double[][]{{2.0, 4.0, 6.0},{8.0, 10.0, 12.0},{14.0, 16.0, 18.0}});
        assertEquals(m1.toString(), "{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}");

        //создание переменной типа Matrix на основе объекта Matrix
        Matrix m2 = new Matrix(m1);
        assertEquals(m2.toString(), "{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}");

        //создание переменной типа Matrix на основе строки
        Matrix m3 = new Matrix("{{2.0, 4.0, 6.0},{8.0, 10.0, 12.0},{14.0, 16.0, 18.0}}");
        assertEquals(m3.toString(), "{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}");

    }

}



