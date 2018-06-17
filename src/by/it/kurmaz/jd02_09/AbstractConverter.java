package by.it.kurmaz.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

abstract class Converter<T> {
    private T bean;
    Class<T> beanClass;

    void save(File file) {
        if (beanClass.equals(String.class)){
            try(Writer writer = new BufferedWriter(new FileWriter(file))) {
                writer.write((String) bean);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(bean, file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {

        this.bean = bean;
    }

    abstract void convert();

    void load(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bean = (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    abstract void load(String line);

    abstract String getText();

}
