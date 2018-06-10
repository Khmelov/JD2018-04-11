package by.it.zakharenko.calc;

public interface Message {
    String VECTORDIFFERENTSIZES="msg.vectordifferentsizes";//Размеры векторов не совпадают
    String MATRICADIFFERENTSIZES="msg.matricadifferentsizes";//Размеры матриц не совпадают
    String DIVBYZERO="msg.divbyzero";//Деление на ноль
    String NOSUCHOPERATION="msg.nosuchoperation";//Такой операции нет
    String ABSTRACTVAR="msg.abstractvar";//Абстрактная переменная
    String CREATEIMPOSSIBLE="msg.createimpossible";//Невозможно создать
    String HANDLEIMPOSSIBLE="msg.handleimpossible";//невозможно обработать
    String ADD="msg.add";
    String SUB="msg.sub";
    String MUL="msg.mul";
    String DIV="msg.div";
    String IMPOSSIBLE="msg.impossible";
}
