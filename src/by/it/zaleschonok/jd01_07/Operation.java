package by.it.zaleschonok.jd01_07;

/**
 * Created by Andrey on 07.05.2018.
 */
interface Operation {
    AbstractVar add(AbstractVar other);
    AbstractVar sub(AbstractVar other);
    AbstractVar mul(AbstractVar other);
    AbstractVar div(AbstractVar other);
}