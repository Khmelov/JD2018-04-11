package by.it.shumilov.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {
    private static String xml = "src/by/it/shumilov/jd02_09/Persons_xsd.xml";
    private static String out = "src/by/it/shumilov/jd02_09/ResultB.xml";

    static Persons persons;


    static void readXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            persons = (Persons)unmarshaller.unmarshal(new File(xml));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    static String getJson(){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String s = gson.toJson(persons);
        return s;
    }

    static void readJson(String json) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        persons = gson.fromJson(json, Persons.class);

    }

    static void saveXml(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(persons, new File(out));



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
