package by.it.rogov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {
    Parser parser = new Parser();

    @Test
    public void calcA1() throws Exception {

        Var var = parser.calc("A=2+5.3");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 7.3, res, 1e-20);
        System.err.println("expected: 7.3  actual:" + res);
    }


    @Test
    public void calcA2() throws Exception {

        Var var = parser.calc("B=A*3.5");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25.55, res, 1e-20);
        System.err.println("expected: 25.55  actual:" + res);
    }

    @Test
    public void calcA3() throws Exception {

        Var var = parser.calc("B1=B+0.11*-5");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25, res, 1e-20);
        System.err.println("expected: 25  actual:" + res);
    }

    @Test
    public void calcA4() throws Exception {

        Var var = parser.calc("B2=A/2-1");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 2.65, res, 1e-20);
        System.err.println("expected: 2.65  actual:" + res);
    }

    @Test
    public void calcB1() throws Exception {

        Var var = parser.calc("C=B+(A*2)");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 40.15, res, 1e-20);
        System.err.println("expected: 40.15  actual:" + res);
    }
    @Test
    public void calcB2() throws Exception {

        Var var = parser.calc("D=((C-0.15)-20)/(7-5)");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 10, res, 1e-20);
        System.err.println("expected: 10  actual:" + res);
    }
//    @Test
//    public void calcB3() throws Exception {
//
//        Var var = parser.calc("E={2,3}*(D/2)");
//        Var res = Double.parseDouble(var.toString());
//        assertEquals("Ошибка", {5.0,15.0}, res, 1e-20);
//        System.err.println("expected: {5,15}  actual:" + res);
//    }






}
