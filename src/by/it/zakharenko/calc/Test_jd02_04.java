package by.it.zakharenko.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {
    @Test
    public void A() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("A=2+5.3");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 7.3, res, 1e-20);

        var = parser.calc("B=A*3.5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25.55, res, 1e-20);

        var = parser.calc("B1=B+0.11*-5");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 25, res, 1e-20);

        var = parser.calc("B2=A/2-1");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 2.65, res, 1e-20);
    }

    @Test
    public void B() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("C=B+(A*2)");
        double res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 40.15, res, 1e-20);

        var = parser.calc("D=((C-0.15)-20)/(7-5)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", 10, res, 1e-20);

        /*var = parser.calc("E={2,3}*(D/2)");
        res = Double.parseDouble(var.toString());
        assertEquals("Ошибка", "{10.0,15.0}", res);*/
    }

    @Test
    public void AddVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}+1");
        assertEquals("Ошибка", "{3.0, 4.0}", var.toString());

        var = parser.calc("1+{2,3}");
        assertEquals("Ошибка", "{3.0, 4.0}", var.toString());

        var = parser.calc("{2,3}+{1,2}");
        assertEquals("Ошибка", "{3.0, 5.0}", var.toString());
    }

    @Test
    public void SubVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}-1");
        assertEquals("Ошибка", "{1.0, 2.0}", var.toString());

        var = parser.calc("{2,3}-2");
        assertEquals("Ошибка", "{0.0, 1.0}", var.toString());

        var = parser.calc("{2,3}-{1,2}");
        assertEquals("Ошибка", "{1.0, 1.0}", var.toString());
    }

    @Test
    public void mulVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}*1");
        assertEquals("Ошибка", "{2.0, 3.0}", var.toString());

        var = parser.calc("2*{2,3}");
        assertEquals("Ошибка", "{4.0, 6.0}", var.toString());

        var = parser.calc("{2,3}*{1,2}");
        assertEquals("Ошибка", "8.0", var.toString());
    }

    @Test
    public void divVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}/1");
        assertEquals("Ошибка", "{2.0, 3.0}", var.toString());

        try{
            var = parser.calc("{2,3}/0");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Деление на ноль " + var + "/" + "0.0", e.getMessage());
        }

        try{
            var = parser.calc("2/{2,3}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция деления 2.0/{2.0, 3.0} невозможна", e.getMessage());
        }

        try{
            var = parser.calc("{2,3}/{1,2}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция деления {2.0, 3.0}/{1.0, 2.0} невозможна", e.getMessage());
        }

    }

    @Test
    public void AddMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{2,3},{3,5}}+1");
        assertEquals("Ошибка", "{{3.0, 4.0}, {4.0, 6.0}}", var.toString());

        try{
            var = parser.calc("{{2,3},{3,5}}+{1,3}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция сложения {{2.0, 3.0}, {3.0, 5.0}}+{1.0, 3.0} невозможна", e.getMessage());
        }

        var = parser.calc("{{2,3},{3,5}}+{{1,3},{1,2}}");
        assertEquals("Ошибка", "{{3.0, 6.0}, {4.0, 7.0}}", var.toString());
    }

    @Test
    public void SubMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{2,3},{3,5}}-1");
        assertEquals("Ошибка", "{{1.0, 2.0}, {2.0, 4.0}}", var.toString());

        try{
            var = parser.calc("{{2,3},{3,5}}-{1,3}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция вычитания {{2.0, 3.0}, {3.0, 5.0}}-{1.0, 3.0} невозможна", e.getMessage());
        }

        var = parser.calc("{{2,3},{3,5}}-{{1,3},{1,2}}");
        assertEquals("Ошибка", "{{1.0, 0.0}, {2.0, 3.0}}", var.toString());
    }

    @Test
    public void mulMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{2,3},{3,5}}*1");
        assertEquals("Ошибка", "{{2.0, 3.0}, {3.0, 5.0}}", var.toString());

        var = parser.calc("{{2,3},{3,5}}*{1,3}");
        assertEquals("Ошибка", "{11.0, 18.0}", var.toString());

        try{
            var = parser.calc("{1,3}*{{2,3},{3,5}}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция умножения {1.0, 3.0}*{{2.0, 3.0}, {3.0, 5.0}} невозможна", e.getMessage());
        }

        var = parser.calc("{{3,1},{1,3}}*{{2,3},{3,5}}");
        assertEquals("Ошибка", "{{9.0, 14.0}, {11.0, 18.0}}", var.toString());
    }

    @Test
    public void divMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{2,3},{3,5}}/1");
        assertEquals("Ошибка", "{{2.0, 3.0}, {3.0, 5.0}}", var.toString());

        try{
            var = parser.calc("{{2,3},{3,5}}/{1,3}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция деления {{2.0, 3.0}, {3.0, 5.0}}/{1.0, 3.0} невозможна", e.getMessage());
        }

        try{
            var = parser.calc("{1,3}/{{2,3},{3,5}}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция деления {1.0, 3.0}/{{2.0, 3.0}, {3.0, 5.0}} невозможна", e.getMessage());
        }

        try{
            var = parser.calc("{{3,1},{1,3}}/{{2,3},{3,5}}");
        }
        catch (Exception e){
            assertEquals("ERROR", "ERROR: Операция деления {{3.0, 1.0}, {1.0, 3.0}}/{{2.0, 3.0}, {3.0, 5.0}} невозможна", e.getMessage());
        }

    }

}