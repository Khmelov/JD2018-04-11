package by.it.tayanovskii.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Calc_Test {

    @Test
    public void add() throws Exception {
        Parser parser = new Parser();

        assertEquals("Ошибка",7.3,Double.parseDouble(parser.calc("2+5.3").toString()),1e-20);
        assertEquals("Ошибка","{4.0,6.0,8.0}",parser.calc("{1,2,3}+{3,4,5}").toString());
        assertEquals("Ошибка","{{4.0,6.0},{11.0,10.0}}",parser.calc("{{1,2},{4,5}}+{{3,4},{7,5}}").toString());
        assertEquals("Ошибка",parser.calc("A=5+3").toString(), "8.0");

    }
    @Test
    public void sub() throws Exception {
        Parser parser = new Parser();
        assertEquals("Ошибка",parser.calc("2-5.3").toString(), "-3.3");
        assertEquals("Ошибка",parser.calc("{1,2,3}-{3,4,5}").toString(), "{-2.0,-2.0,-2.0}");
        assertEquals("Ошибка",parser.calc("{1,-2,3}-{-3,4,5}").toString(), "{4.0,-6.0,-2.0}");
        assertEquals("Ошибка",parser.calc("{{1,2},{4,5}}-{{3,4},{7,5}}").toString(), "{{-2.0,-2.0},{-3.0,0.0}}");
        assertEquals("Ошибка",parser.calc("{{-1,2},{4,-5}}-{{3,4},{-7,5}}").toString(), "{{-4.0,-2.0},{11.0,-10.0}}");


    }

    @Test
    public void div() throws Exception {
        Parser parser = new Parser();
        assertEquals("Ошибка",parser.calc("7/2").toString(), "3.5");
        assertEquals("Ошибка",parser.calc("12/-6").toString(), "-2.0");
        assertEquals("Ошибка",parser.calc("{2,2,-4}/0.5").toString(), "{4.0,4.0,-8.0}");
        assertEquals("Ошибка",parser.calc("{{-9,18},{6,-33}}/3").toString(), "{{-3.0,6.0},{2.0,-11.0}}");
    }

    @Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        assertEquals("Ошибка",parser.calc("7.3*3.5").toString(), "25.55");
        assertEquals("Ошибка",parser.calc("{1,2,3}*{3,4,5}").toString(), "26.0");
        assertEquals("Ошибка",parser.calc("5*{{1,10},{6,3}}").toString(), "{{5.0,50.0},{30.0,15.0}}");
        assertEquals("Ошибка",parser.calc("-5*{1,2.5,-4}").toString(), "{-5.0,-12.5,20.0}");
        assertEquals("Ошибка",parser.calc("{{1,2},{4,5}}*{{3,4},{7,5}}").toString(), "{{17.0,14.0},{47.0,41.0}}");
        assertEquals("Ошибка",parser.calc("{{1,-2},{8,-3}}*{1,-2}").toString(), "{5.0,14.0}");

    }

    @Test
    public void main() throws Exception{
        Parser parser=new Parser();
        assertEquals(parser.calcExpression("A=2+5.3").toString(),"7.3");
        assertEquals(parser.calcExpression("B=A*3.5").toString(),"25.55");
        assertEquals(parser.calcExpression("B1=B+0.11*-5").toString(),"25.0");
        assertEquals(parser.calcExpression("B2=A/2-1").toString(),"2.65");
        assertEquals(parser.calcExpression("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calcExpression("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calcExpression("E={2,3}*D/2").toString(),"{10.0,15.0}");
    }



}