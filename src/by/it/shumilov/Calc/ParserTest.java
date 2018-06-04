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

        var = parser.calc("B=A*3.5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",25.55,res,1e-20);

        var = parser.calc("B1=B+0.11*-5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",25,res,1e-20);

        var = parser.calc("B2=A/2-1");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",2.65,res,1e-20);

        var = parser.calc("C=B+(A*2)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",40.15,res,1e-20);

        var = parser.calc("D=((C-0.15)-20)/(7-5)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",10,res,1e-20);

        var = parser.calc("E={2,3}*(D/2)");
        assertEquals("Ошибка","{10.0,15.0}",var.toString());


    }
}