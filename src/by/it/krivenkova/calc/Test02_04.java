package by.it.krivenkova.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test02_04 {
    @Test
    public void add() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("A=2+5.3");

        double res=Double.parseDouble(var.toString());
        assertEquals("Ошибка",7.3,res,1e-20);
       // assertEquals(parser.calc("A=2+5.3").toString(),"7.3");
        parser.calc("A=2+5.3");
        parser.calc("B=A*3.5");
     //   assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");
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
     //   parser.calc("C=B+(A*2)");
     //   parser.calc("D=((C-0.15)-20)/(7-5)");

        assertEquals(parser.calc("B=A*3.5").toString(),"25.55");
     //   assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
     //   assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10,15}");
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