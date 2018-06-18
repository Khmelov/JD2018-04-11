package by.it.dkruchek.jd02_09.TaskC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

class ConverterXmlToJson<T> extends Converter<T>{

    public ConverterXmlToJson(Class<T> type) {
        super(type);
    }

    @Override
    void load(String string) {
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            bean = (T) unmarshaller.unmarshal(new StringReader(string));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    void load(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            bean = (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    void save(File file) {
        try (Writer writer = new FileWriter(file.getAbsolutePath())) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(bean, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void convert(){
        System.out.println("Converted");
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        result = gson.toJson(bean);
    }
}
