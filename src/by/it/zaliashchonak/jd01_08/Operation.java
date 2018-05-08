package by.it.zaliashchonak.jd01_08;

/**
 * Created by Andrey on 07.05.2018.
 */
public interface Operation {

    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);
}