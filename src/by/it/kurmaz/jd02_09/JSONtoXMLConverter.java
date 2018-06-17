package by.it.kurmaz.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import java.io.*;

class JSONtoXMLConverter extends Converter {

    private String json;

    JSONtoXMLConverter(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    void load(String line) {
        json = line;
    }

    @Override
    void convert() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        setBean(gson.fromJson(json, beanClass));
    }

    @Override
    String getText() {
    String output = "";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = jaxbContext.createMarshaller();
            Writer writer = new StringWriter();
            marshaller.marshal(getBean(), writer);
            output = writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return output;
    }
}
