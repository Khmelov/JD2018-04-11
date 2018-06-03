package by.it.rogov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {

    @Test
    public void calcA1() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("A=2+5.3");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 7.3, res, 1e-20);
    }


    @Test
    public void calcA2() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("B=A*3.5");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25.55, res, 1e-20);
    }
    @Test
    public void calcA3() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("B1=B+0.11*-5");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25, res, 1e-20);
    }

    @Test
    public void calcA4() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("B2=A/2-1");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 2.65, res, 1e-20);
    }
}
