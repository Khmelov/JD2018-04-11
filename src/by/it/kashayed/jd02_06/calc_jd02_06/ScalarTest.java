package by.it.kashayed.jd02_06.calc_jd02_06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScalarTest {

    @Test (timeout = 5000)
    public void add() throws Exception {
        Parser parser=new Parser();
        Var res = parser.calc("A=1+2");
        String s = res.toString();
        assertEquals("3.0",s);
    }

    @Test(timeout = 5000)
    public void sub() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("B=3-2");
        String s = res.toString();
        assertEquals("1.0",s);
    }

    @Test(timeout = 5000)
    public void mul() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("C=3*2");
        String s = res.toString();
        assertEquals("6.0",s);
    }

    @Test(timeout = 5000)
    public void div() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("Q=8/2");
        String s = res.toString();
        assertEquals("4.0",s);
    }
}