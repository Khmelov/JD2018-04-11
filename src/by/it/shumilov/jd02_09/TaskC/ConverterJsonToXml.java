package by.it.shumilov.jd02_09.TaskC;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class ConverterJsonToXml extends Converter {
    ConverterJsonToXml(Class<?> bean) {
        super(bean);
    }


    @Override
    void load(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String schema = bufferedReader.lines().reduce((s1, s2) -> s1 + s2).orElse("");
            this.load(schema);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    void load(String schema) {

        try {
            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

            Object objects =super.getBean().newInstance();
            objects = gson.fromJson(schema, super.getBean());

            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(objects, stringWriter);


            super.setResult(stringWriter.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
