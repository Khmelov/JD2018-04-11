package by.it.dkruchek.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitriy.Kruchek on 6/3/2018.
 */
public class CalcTests {

    Parser parser;

    @Before
    public void setUp(){
        parser = new Parser();
    }

    @Test()
    public void testScalarOperationsAdd() throws Exception{
        // scalar and scalar operations
        assertEquals(parser.calc("11+11.11").toString(), "22.11");
        assertEquals(parser.calc("-11+-11").toString(), "-22.0");
        assertEquals(parser.calc("11+-11").toString(), "0.0");
        // scalar and vector
        assertEquals(parser.calc("{11,11,11}+11.1").toString(), "{22.1, 22.1, 22.1}");
        assertEquals(parser.calc("11+{11.1, 11.1,11.1}").toString(), "{22.1, 22.1, 22.1}");
        // scalar and matrix
        assertEquals(parser.calc("11+{{11,11},{11,11}}").toString(), "{{22.0, 22.0}, {22.0, 22.0}}");
        assertEquals(parser.calc("{{11,11},{11,11}}+11").toString(), "{{22.0, 22.0}, {22.0, 22.0}}");
    }

    @Test()
    public void testScalarOperationsSub() throws Exception{
        // scalar and scalar operations
        assertEquals(parser.calc("11-11").toString(), "0.0");
        assertEquals(parser.calc("-11--11").toString(), "0.0");
        assertEquals(parser.calc("-11-11").toString(), "-22.0");
        // scalar and vector
        assertEquals(parser.calc("{11,11,11}-11").toString(), "{0.0, 0.0, 0.0}");
        // scalar and matrix
        assertEquals(parser.calc("{{11,11},{11,11}}-11").toString(), "{{0.0, 0.0}, {0.0, 0.0}}");
    }

    @Test()
    public void testScalarOperationsMul() throws Exception{
        // scalar and scalar operations
        assertEquals(parser.calc("11*11").toString(), "121.0");
        assertEquals(parser.calc("-11*-11").toString(), "121.0");
        assertEquals(parser.calc("-11*11").toString(), "-121.0");
        // scalar and vector
        assertEquals(parser.calc("{11,11,11}*11").toString(), "{121.0, 121.0, 121.0}");
        // scalar and matrix
        assertEquals(parser.calc("{{11,11},{11,11}}*-11").toString(), "{{-121.0, -121.0}, {-121.0, -121.0}}");
    }

    @Test()
    public void testVectorOperationsAdd() throws Exception{
        // vector and vector
        assertEquals(parser.calc("{11,11,11}+{11,11,11}").toString(), "{22.0, 22.0, 22.0}");
    }

    @Test()
    public void testVectorOperationsSub() throws Exception{
        // vector and vector
        assertEquals(parser.calc("{11,11,11}-{11,11,11}").toString(), "{0.0, 0.0, 0.0}");
    }

    @Test()
    public void testVectorOperationsMul() throws Exception{
        // vector and vector
        assertEquals(parser.calc("{11,11,11}*{11,11,11}").toString(), "363.0");
    }

    @Test()
    public void testMatrixOperationsAdd() throws Exception{
        // matrix and matrix
        assertEquals(parser.calc("{{11,11},{11,11}}+{{11,11},{11,11}}").toString(), "{{22.0, 22.0}, {22.0, 22.0}}");
    }

    @Test()
    public void testMatrixOperationsSub() throws Exception{
        // matrix and matrix
        assertEquals(parser.calc("{{11,11},{11,11}}-{{11,11},{11,11}}").toString(), "{{0.0, 0.0}, {0.0, 0.0}}");
    }

    @Test()
    public void testMatrixOperationsMul() throws Exception{
        // matrix and matrix
        assertEquals(parser.calc("{{11,11},{11,11}}*{{11,11},{11,11}}").toString(), "{{242.0, 242.0}, {242.0, 242.0}}");
    }

    @Test()
    public void testScalarOperationsDiv() throws Exception{
        // scalar and scalar operations
        assertEquals(parser.calc("11/11").toString(), "1.0");
        assertEquals(parser.calc("-11/-11").toString(), "1.0");
        assertEquals(parser.calc("-11/11").toString(), "-1.0");
        // scalar and vector
        assertEquals(parser.calc("{11,11,11}/11").toString(), "{1.0, 1.0, 1.0}");
        // scalar and matrix
        assertEquals(parser.calc("{{11,11},{11,11}}/-11").toString(), "{{-1.0, -1.0}, {-1.0, -1.0}}");
    }

    @Test
    public void testCalcOperationsFromMemory() throws Exception {
        assertEquals(parser.calc("A=11+11").toString(), "22.0");
        assertEquals(parser.calc("B=11.11+11.11").toString(), "22.22");
        assertEquals(parser.calc("C=A+B").toString(), "44.22");
        // scalar and vector
        assertEquals(parser.calc("D={11,11,-11}+11").toString(), "{22.0, 22.0, 0.0}");
        assertEquals(parser.calc("E=11+{11,11,-11}").toString(), "{22.0, 22.0, 0.0}");
        assertEquals(parser.calc("F=D+E").toString(), "{44.0, 44.0, 0.0}");
        // scalar and matrix
        assertEquals(parser.calc("J={{11,11},{11,11}}+11").toString(), "{{22.0, 22.0}, {22.0, 22.0}}");
        assertEquals(parser.calc("I=11+{{11,11},{11,11}}").toString(), "{{22.0, 22.0}, {22.0, 22.0}}");
        assertEquals(parser.calc("H=J+I").toString(), "{{44.0, 44.0}, {44.0, 44.0}}");
    }

    @Test
    public void testCalcOperationsParenthesesExpressions() throws Exception {
        assertEquals(parser.calc("A=2+5.3").toString(), "7.3");
        assertEquals(parser.calc("B=A*3.5").toString(), "25.55");
        assertEquals(parser.calc("B1=B+0.11*-5").toString(), "25.0");
        assertEquals(parser.calc("B2=A/2-1").toString(), "2.65");
        assertEquals(parser.calc("C=B+(A*2)").toString(),"40.15");
        assertEquals(parser.calc("D=((C-0.15)-20)/(7-5)").toString(),"10.0");
        assertEquals(parser.calc("E={2,3}*(D/2)").toString(),"{10.0, 15.0}");
    }
}