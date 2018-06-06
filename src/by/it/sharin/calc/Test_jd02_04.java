package by.it.sharin.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {
    @Test
    public void calc() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("A=2+5.3");
        double res=Double.parseDouble(var.toString());
        assertEquals("Ошибка",7.3,res,1e-20);
    }
}
