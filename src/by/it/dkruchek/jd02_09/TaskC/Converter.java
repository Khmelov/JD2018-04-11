package by.it.dkruchek.jd02_09.TaskC;

import java.io.File;

abstract class Converter<T> {

    T bean;
    String result;
    Class<T> beanClass;

    public Converter(Class<T> type) {
        this.beanClass = type;
    }

    abstract void load(String String);

    abstract void load(File file);

    abstract void save(File file);

    String getText(){
        return result;
    }

    abstract void convert();


}
