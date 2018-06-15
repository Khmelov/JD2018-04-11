package by.it.dkruchek.jd02_09.TaskC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConverterJsonToXml extends Converter{

    private Gson gson = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    @Override
    void load(String string) {
        bean = gson.fromJson(string, beanClass);
    }

    @Override
    void load(File file) {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(file.getAbsolutePath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bean = gson.fromJson(reader, beanClass);
    }

    @Override
    void save(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
