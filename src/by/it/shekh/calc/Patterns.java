package by.it.shekh.calc;

abstract class Patterns {
    //слева от операции должна стоять либо буква, либо цифра либо закрывающаяся фигурная скобка
    static final String OPERATION = "[+*/=]|(?<=[a-zA-Zа-яА-ЯёЁ0-9}])-";
    static final String SCALAR = "-?(\\d*)?(\\.\\d+)?(?<=\\d)([Ee]-?(\\d*))?";
    static final String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?\\s*)+}";
    static final String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?\\s*)+},?\\s*)+}";
    static final String VARNAME = "[a-zA-Zа-яА-ЯёЁ][a-zA-Zа-яА-ЯёЁ0-9]*";
    static final String BRACKETS = "(\\()([^\\(\\)]*)(\\))";
}
