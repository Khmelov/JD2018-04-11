package by.it.dkruchek.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {
//
//    public static Persons persons;
//    private static final String XML = "src/by/it/dkruchek/jd02_09/Persons_xsd.xml";
//    private static final String XML_OUT = "src/by/it/dkruchek/jd02_09/Persons_out.xml";
//
//
//    static void readXml() {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Persons.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            persons = (Persons) unmarshaller.unmarshal(new File(XML));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
//    static String getJson() {
//        Gson gson = new GsonBuilder()
//                .serializeNulls()
//                .setPrettyPrinting()
//                .create();
//        String json = gson.toJson(persons);
//
//        return json;
//    }
//
//    static void readJson(String json) {
//
//        Gson gson = new GsonBuilder()
//            .serializeNulls()
//            .setPrettyPrinting()
//            .create();
//        persons = gson.fromJson(json, Persons.class);
//    }
//
//    static void saveXml(){
//        try {
//            JAXBContext context = JAXBContext.newInstance(Persons.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(persons, new File("src/by/it/dkruchek/jd02_09/Persons_out.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        readXml();
//        String json = getJson();
//        System.out.println(json);
//        readJson(json);
//        saveXml();
//
//
//    }
}
