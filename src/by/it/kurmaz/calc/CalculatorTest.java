package by.it.kurmaz.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void ScalarTest() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2.5 + 3.2");
        double res=Double.parseDouble(var.toString());
        assertEquals("Ошибка",5.7,res,1e-10);

        var = parser.calc("7.3 - 2.1");
        res=Double.parseDouble(var.toString());
        assertEquals("Ошибка",5.2,res,1e-10);

        var = parser.calc("6.1 * 3");
        res=Double.parseDouble(var.toString());
        assertEquals("Ошибка",18.3,res,1e-10);

        var = parser.calc("18.3 / 3");
        res=Double.parseDouble(var.toString());
        assertEquals("Ошибка",6.1,res,1e-10);
    }

    @Test
    public void VectorTest() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1, 2, 3} + {4, 5, 6}");
        assertEquals("Ошибка","{5.0, 7.0, 9.0}", var.toString());

        var = parser.calc("{1, 2, 3} + 5");
        assertEquals("Ошибка","{6.0, 7.0, 8.0}", var.toString());

        var = parser.calc("{4, 5, 6} - {1, 2, 3}");
        assertEquals("Ошибка","{3.0, 3.0, 3.0}", var.toString());

        var = parser.calc("{4, 5, 6} - 2");
        assertEquals("Ошибка","{2.0, 3.0, 4.0}", var.toString());

        var = parser.calc("{4, 5, 6} * {1, 2, 3}");
        assertEquals("Ошибка","32.0", var.toString());
    }

    @Test
    public void MatrixTest() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{1, 2, 3}, {4, 5, 6}} + 5");
        assertEquals("Ошибка","{{6.0, 7.0, 8.0}, {9.0, 10.0, 11.0}}", var.toString());

        var = parser.calc("{{1, 2, 3}, {4, 5, 6}} + {{6, 5, 4}, {3, 2, 1}}");
        assertEquals("Ошибка","{{7.0, 7.0, 7.0}, {7.0, 7.0, 7.0}}", var.toString());


        var = parser.calc("{{6, 5, 4}, {3, 2, 1}} - {{1, 2, 3}, {4, 5, 6}}");
        assertEquals("Ошибка","{{5.0, 3.0, 1.0}, {-1.0, -3.0, -5.0}}", var.toString());

        var = parser.calc("{{6, 5, 4}, {3, 2, 1}} - 2");
        assertEquals("Ошибка","{{4.0, 3.0, 2.0}, {1.0, 0.0, -1.0}}", var.toString());


        var = parser.calc("{{1, 2, 3}, {4, 5, 6}} * {{6, 5}, {4, 3}, {2, 1}}");
        assertEquals("Ошибка","{{20.0, 14.0}, {56.0, 41.0}}", var.toString());

        var = parser.calc("{{1, 2, 3}, {4, 5, 6}} * 3");
        assertEquals("Ошибка","{{3.0, 6.0, 9.0}, {12.0, 15.0, 18.0}}", var.toString());

        var = parser.calc("{{1, 2, 3}, {4, 5, 6}} * {1, 2, 3}");
        assertEquals("Ошибка","{14.0, 32.0}", var.toString());

        var = parser.calc("{{1, 2, 3}, {4, 5, 6}} / 2");
        assertEquals("Ошибка","{{0.5, 1.0, 1.5}, {2.0, 2.5, 3.0}}", var.toString());
    }

    @Test
    public void VarTest() throws Exception {

        Scalar sc1 = (Scalar) Var.createVar("5");
        assert sc1 != null;
        assertEquals("Ошибка", "5.0", sc1.toString());

        Scalar sc3 = new Scalar(5.5);

        Scalar sc2 = new Scalar(sc3);
        assertEquals("Ошибка", "5.5", sc2.toString());

        Vector v1 = new Vector(new double[]{3, 2, 1});
        assertEquals("Ошибка", "{3.0, 2.0, 1.0}", v1.toString());

        Vector v2 = new Vector(v1);
        assertEquals("Ошибка", "{3.0, 2.0, 1.0}", v2.toString());

        Vector v3 = (Vector) Var.createVar("{5, 6, 7}");
        assert v3 != null;
        assertEquals("Ошибка", "{5.0, 6.0, 7.0}", v3.toString());

        Matrix mx1 = new Matrix(new double[][] {{3, 2, 1}, {6, 5, 4}});
        assertEquals("Ошибка", "{{3.0, 2.0, 1.0}, {6.0, 5.0, 4.0}}", mx1.toString());

        Matrix mx2 = new Matrix(mx1);
        assertEquals("Ошибка", "{{3.0, 2.0, 1.0}, {6.0, 5.0, 4.0}}", mx2.toString());

        Matrix mx3 = (Matrix) Var.createVar("{{1, 2, 3}, {4, 5, 6}}");
        assert mx3 != null;
        assertEquals("Ошибка", "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}", mx3.toString());

    }

}