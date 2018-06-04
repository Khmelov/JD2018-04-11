package by.it.shekh.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {

    @Test
    public void calc() throws Exception{
        Parser parser = new Parser();
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
}