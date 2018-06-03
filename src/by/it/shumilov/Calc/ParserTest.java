package by.it.shumilov.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testCalc() throws Exception{
        Parser parser = new Parser();
        Var var = parser.calc("A=2+5.3");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",7.3,res,1e-20);
    }
}