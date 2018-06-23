package by.it.tayanovskii.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static final String XML="src/by/it/tayanovskii/jd02_09/Readers+xsd.xml";
    private static final String XMLOUT="src/by/it/tayanovskii/jd02_09/Readers+xsd_out.xml";

    static Readers readers;

    static void readXml(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Readers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            readers = (Readers) unmarshaller.unmarshal(new File(XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static String getJson() {
        Gson gson=new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(readers);
        return json;
    }

    static void readJson(String json){
        Gson gson=new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        readers=gson.fromJson(json,Readers.class);
    }

    static void saveXml(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Readers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(readers,new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readXml();
        String json = getJson();
        System.out.println(json);
        readJson(json);
        saveXml();
    }
}
