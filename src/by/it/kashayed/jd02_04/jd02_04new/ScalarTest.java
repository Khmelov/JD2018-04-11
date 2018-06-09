package by.it.kashayed.jd02_04.jd02_04new;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    @Test
    public void add() throws Exception {
        Parser parser=new Parser();
        Var res = parser.calc("1+2");
        Var s =new Scalar(3);
        assertEquals(s,res);
    }

    @Test
    public void sub() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("3-2");
       // Scalar s =new Scalar(1);
        assertEquals(1.0,res);
    }

    @Test
    public void mul() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("3*2");
        Scalar s =new Scalar(6);
        assertEquals(s,res);
    }

    @Test
    public void div() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("8/2");
        Scalar s =new Scalar(4);
        assertEquals(s,res);
    }
}