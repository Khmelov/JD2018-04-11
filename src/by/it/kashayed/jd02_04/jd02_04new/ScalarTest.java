package by.it.kashayed.jd02_04.jd02_04new;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    @Test
    public void add() throws Exception {
        Var res = Var.createVar("1+2");
        assertEquals(3,res);
    }

    @Test
    public void sub() throws Exception{
        Var res =  Var.createVar("3-2");
        assertEquals(1,res);
    }

    @Test
    public void mul() throws Exception{
        Var res = Var.createVar("4*2");
        assertEquals(8,res);
    }

    @Test
    public void div() throws Exception{
        Var res = Var.createVar("4/2");
        assertEquals(2,res);
    }
}