package by.it.shumilov.jd02_09.TaskC;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.io.StringReader;

public class ConverterXmlToJson extends Converter {
    ConverterXmlToJson(Class<?> bean) {
        super(bean);
    }

    @Override
    void load(File file) {
        try {
            Class<?> bean = super.getBean();


            JAXBContext jaxbContext = JAXBContext.newInstance(bean);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            //Object objects =super.getBean().newInstance();
            Object objects = unmarshaller.unmarshal(file);

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            super.setResult(gson.toJson(objects));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    void load(String schema) {


        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(super.getBean());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Object objects =super.getBean().newInstance();
            objects = unmarshaller.unmarshal(new StringReader(schema));

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            super.setResult(gson.toJson(objects));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
