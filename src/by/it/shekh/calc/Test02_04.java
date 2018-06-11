package by.it.shekh.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {

    Parser parser = new Parser();

    @Test
    public void calc() throws Exception{
        Var var1 = parser.calc("A=2+5.3");
        double res1=Double.parseDouble(var1.toString());
        assertEquals("Ошибка для выражения",7.3,res1,1e-20);
        Var var2=parser.calc("B=3*-2.3");
        double res2=Double.parseDouble(var2.toString());
        assertEquals("Ошибка для выражения",-6.9,res2,1e-5);
        Var var3=parser.calc("C=1213/3.1");
        double res3=Double.parseDouble(var3.toString());
        assertEquals("Ошибка для выражения",391.29,res3,1e-3);
        Var var4=parser.calc("B=3--2.3");
        double res4=Double.parseDouble(var4.toString());
        assertEquals("Ошибка для выражения",5.3,res4,1e-20);
    }

    @Test
    public void scalarTest() throws Exception{
        assertEquals(parser.calc("3+-4").toString(),"-1.0");
        assertEquals(parser.calc("-3+-4").toString(),"-7.0");
        assertEquals(parser.calc("-3+4").toString(),"1.0");
        assertEquals(parser.calc("3*-4").toString(),"-12.0");
        assertEquals(parser.calc("3/-4").toString(),"-0.75");
        assertEquals(parser.calc("3*{4,2}").toString(),"{12.0, 6.0}");
    }

    @Test
    public void vectorTest() throws Exception{
        assertEquals(parser.calc("{3,2}+2").toString(),"{5.0, 4.0}");
        assertEquals(parser.calc("{-3,2}+-2").toString(),"{-5.0, 0.0}");
        assertEquals(parser.calc("{3,2}+{3.2,-1}").toString(),"{6.2, 1.0}");
        assertEquals(parser.calc("{3,2}-{2,2}").toString(),"{1.0, 0.0}");
        assertEquals(parser.calc("{3,2}*{2,3}").toString(),"12.0");
        assertEquals(parser.calc("{3,2}*-2").toString(),"{-6.0, -4.0}");
        assertEquals(parser.calc("3*{4,2}").toString(),"{12.0, 6.0}");
        assertEquals(parser.calc("{4,2}/2").toString(),"{2.0, 1.0}");
    }
    @Test
    public void matrixTest() throws Exception {
        assertEquals(parser.calc("{{3,2},{5,-1}}+2").toString(), "{{5.0, 4.0}, {7.0, 1.0}}");
        assertEquals(parser.calc("{{3,2},{5,-1}}-2").toString(), "{{1.0, 0.0}, {3.0, -3.0}}");
        assertEquals(parser.calc("{{3,2},{5,-1}}*2").toString(), "{{6.0, 4.0}, {10.0, -2.0}}");
        assertEquals(parser.calc("{{3,2},{5,-1}}/2").toString(), "{{1.5, 1.0}, {2.5, -0.5}}");

        assertEquals(parser.calc("{{3,2},{5,-1}}*{2,4}").toString(), "{14.0, 6.0}");

        assertEquals(parser.calc("{{3,2},{5,-1}}+{{8,-12},{6,-2}}").toString(),"{{11.0, -10.0}, {11.0, -3.0}}");
        assertEquals(parser.calc("{{3,2},{5,-1}}-{{8,-12},{6,-2}}").toString(),"{{-5.0, 14.0}, {-1.0, 1.0}}");
        assertEquals(parser.calc("{{3,2},{5,-1}}*{{8,-12},{6,-2}}").toString(),"{{36.0, -40.0}, {34.0, -58.0}}");

    }
}