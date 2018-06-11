package by.it.kashayed.jd02_04.jd02_04new;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void add() throws Exception {
        Parser parser=new Parser();
        Var res = parser.calc("A={1,2}+2");
        String s = res.toString();
        assertEquals("{2,4}",s);
    }

    @Test
    public void sub() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("A={1,2}-2");
        String s = res.toString();
        assertEquals("{-1,0}",s);
    }

    @Test
    public void mul() throws Exception{
        Parser parser=new Parser();
        Var res = parser.calc("A={1,2}*3");
        String s = res.toString();
        assertEquals("{3,6}",s);
    }

    @Test
    public void div() throws Exception {
        Parser parser=new Parser();
        Var res = parser.calc("A={1,2}/2");
        String s = res.toString();
        assertEquals("null",s);
    }
}