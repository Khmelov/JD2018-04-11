package by.it.shumilov.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {
    private static String xml = "src/by/it/shumilov/jd02_09/Persons_xsd.xml";
    private static String out = "src/by/it/shumilov/jd02_09/out.xml";

    static Persons persons;


    static void readXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            persons = (Persons)unmarshaller.unmarshal(new File(xml));
            System.out.println(persons);
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

    }

    public static void main(String[] args) {

    }
}
