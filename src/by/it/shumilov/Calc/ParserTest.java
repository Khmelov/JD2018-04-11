package by.it.shumilov.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testScalar() throws Exception{
        Parser parser = new Parser();

        Var var = parser.calc("A=2+5.3");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",7.3,res,1e-20);

        var = parser.calc("B=A*3.5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",25.55,res,1e-20);

        var = parser.calc("B1=B+0.11*-5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",25,res,1e-20);

        var = parser.calc("B2=A/2-1");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",2.65,res,1e-20);

        try{
            var = parser.calc("2/0");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Деление на ноль",e.getMessage());
        }


        var = parser.calc("C=B+(A*2)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",40.15,res,1e-20);

        var = parser.calc("D=((C-0.15)-20)/(7-5)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка",10,res,1e-20);

        var = parser.calc("E={2,3}*(D/2)");
        assertEquals("Ошибка","{10.0,15.0}",var.toString());


    }

    @Test
    public void testVector() throws Exception{
        Parser parser = new Parser();

        Var var = parser.calc("{1,2}+2");
        assertEquals("Ошибка","{3.0,4.0}",var.toString());

        var = parser.calc("{1,2}*2");
        assertEquals("Ошибка","{2.0,4.0}",var.toString());

        var = parser.calc("{1,2}/2");
        assertEquals("Ошибка","{0.5,1.0}",var.toString());

        try{
            var = parser.calc("{1,2}/0");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Деление на ноль",e.getMessage());
        }

        var = parser.calc("{1,2}-2");
        assertEquals("Ошибка","{-1.0,0.0}",var.toString());

        var = parser.calc("{1,2}-{3,4}");
        assertEquals("Ошибка","{-2.0,-2.0}",var.toString());

        var = parser.calc("{1,2}*{3,4}");
        assertEquals("Ошибка","11.0",var.toString());

        try
        {
            var = parser.calc("{1,2}/{3,4}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция деления {1.0,2.0}/{3.0,4.0} невозможна",e.getMessage());
        }

        var = parser.calc("{1,2}+{3,4}");
        assertEquals("Ошибка","{4.0,6.0}",var.toString());

        try{
            var = parser.calc("2/{3,4}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция деления 2.0/{3.0,4.0} невозможна",e.getMessage());
        }

        var = parser.calc("1+{3,4}");
        assertEquals("Ошибка","{4.0,5.0}",var.toString());

        var = parser.calc("2*{1,2}");
        assertEquals("Ошибка","{2.0,4.0}",var.toString());

        var = parser.calc("2-{1,2}");
        assertEquals("Ошибка","{1.0,0.0}",var.toString());

        }
    @Test
    public void testMatrix() throws Exception{
        Parser parser = new Parser();

        Var var = parser.calc("{{1,2},{3,4}}+2");
        assertEquals("Ошибка","{{3.0,4.0},{5.0,6.0}}",var.toString());

        var = parser.calc("{{1,2},{3,4}}*2");
        assertEquals("Ошибка","{{2.0,4.0},{6.0,8.0}}",var.toString());

        var = parser.calc("{{1,2},{3,4}}-2");
        assertEquals("Ошибка","{{-1.0,0.0},{1.0,2.0}}",var.toString());

        var = parser.calc("{{1,2},{3,4}}/2");
        assertEquals("Ошибка","{{0.5,1.0},{1.5,2.0}}",var.toString());

        try{
            var = parser.calc("{{1,2},{3,4}}/0");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Деление на ноль",e.getMessage());
        }



        var = parser.calc("{{1,2},{3,4}}*2");
        assertEquals("Ошибка","{{2.0,4.0},{6.0,8.0}}",var.toString());

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        var = parser.calc("{{1,2},{3,4}}*{1,2}");
        assertEquals("Ошибка","{5.0,11.0}",var.toString());


        try{
            var = parser.calc("{1,2}*{{1,2},{3,4}}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция умножения {1.0,2.0}*{{1.0,2.0},{3.0,4.0}} невозможна",e.getMessage());
        }

        try{
            var = parser.calc("{{1,2},{3,4}}-{1,2}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция вычитания {{1.0,2.0},{3.0,4.0}}, {1.0,2.0} невозможна",e.getMessage());
        }

        try{
            var = parser.calc("{{1,2},{3,4}}/{1,2}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция деления {{1.0,2.0},{3.0,4.0}}/{1.0,2.0} невозможна",e.getMessage());
        }

        try{
            var = parser.calc("{{1,2},{3,4}}+{1,2}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция сложения {{1.0,2.0},{3.0,4.0}}+{1.0,2.0} невозможна",e.getMessage());
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        var = parser.calc("{{1,2},{3,4}}+{{1,2},{3,4}}");
        assertEquals("Ошибка","{{2.0,4.0},{6.0,8.0}}",var.toString());

        var = parser.calc("{{1,2},{3,4}}*{{1,2},{3,4}}");
        assertEquals("Ошибка","{{7.0,10.0},{15.0,22.0}}",var.toString());

        var = parser.calc("{{1,2},{3,4}}-{{1,2},{3,4}}");
        assertEquals("Ошибка","{{0.0,0.0},{0.0,0.0}}",var.toString());

        try{
            var = parser.calc("{{1,2},{3,4}}/{{1,2},{3,4}}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция деления {{1.0,2.0},{3.0,4.0}}/{{1.0,2.0},{3.0,4.0}} невозможна",e.getMessage());
        }

        try{
            var = parser.calc("{{1,2},{3,4}}*{{1,2},{3,4},{1,2}}");
        }
        catch (Exception e){
            assertEquals("Ошибка","ERROR: Операция умножения невозможна: нет соответствя условию равности количества столбцов{{1.0,2.0},{3.0,4.0}} количеству cтрок {{1.0,2.0},{3.0,4.0},{1.0,2.0}}",e.getMessage());
        }



    }

}