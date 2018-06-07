package by.it.dkruchek.calc;

/**
 * Created by Dmitriy.Kruchek on 6/5/2018.
 */
public interface ERROR {
    String SIMPLE = "error.simple";

}

interface MatrixError{
    String NOT_EQUAL = "error.matrix.notequal";

}

interface VectorError{
    String NOT_EQUAL = "error.vector.notequal";
}

interface ParserError{
    String EMPTY = "error.empty";
    String UNKNOWN = "error.unknown";

}

interface ScalarError{
    String DIVISION_BY_ZERO = "error.scalar.divisionbyzero";
    String DIVISION_BY_VECTOR = "error.scalar.divisionbyvector";
}

interface VarError{
    String UNSUPPORTED_TYPE = "error.var.unsupportedtype";
    String ADD_IMPOSSIBLE = "error.var.add";
    String SUB_IMPOSSIBLE = "error.var.sub";
    String MUL_IMPOSSIBLE = "error.var.mul";
    String DIV_IMPOSSIBLE = "error.var.div";
}

