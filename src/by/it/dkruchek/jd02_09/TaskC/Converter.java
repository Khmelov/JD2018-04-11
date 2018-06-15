package by.it.dkruchek.jd02_09.TaskC;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public abstract class Converter<T> {

    T bean;
    Class<T> beanClass;

    abstract void load(String String);

    abstract void load(File file);

    abstract void save(File file);

    String getText(){
        return bean.toString();
    }

    //public abstract void convert();


}
