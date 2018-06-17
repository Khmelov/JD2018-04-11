package by.it.kurmaz.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

class XMLtoJSONConverter extends Converter {

    XMLtoJSONConverter(Class beanClass) {
        this.beanClass = beanClass;
    }

    private String json;

    @Override
    void load(String line) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Reader reader = new BufferedReader(new StringReader(line));
            setBean(unmarshaller.unmarshal(reader));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    void convert() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        json = gson.toJson(getBean());
        this.beanClass = json.getClass();
        setBean(json);
    }

    @Override
    String getText() {
        return json;
    }
}
