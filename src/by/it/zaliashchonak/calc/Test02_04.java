package by.it.zaliashchonak.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test02_04 {
    @Test
    public void add() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("A=2+5.3");

        double res=Double.parseDouble(var.toString());
        assertEquals("Ошибка",7.3,res,1e-20);
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
    }
    @Test
    public void sub()throws Exception{
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("B1=B+0.11*-5").toString(),"25.0");

    }
    @Test
    public void mul()throws Exception{
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        assertEquals(parser.calc("B=A*3.5").toString(),"25.55");

    }
    @Test
    public void div()throws Exception{
        Parser parser = new Parser();
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
        parser.calc("B1=B+0.11*-5");
        assertEquals(parser.calc("B2=A/2-1").toString(),"2.65");

    }

}