package by.it.kurmaz.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static final String XMLIN="src/by/it/kurmaz/jd02_09/Clients + xsd.xml";
    private static final String XMLOUT="src/by/it/kurmaz/jd02_09/ResultB.xml";
    private static Clients clients;

    public static void main(String[] args) {
        readXML();
        String json = getJSON();
        System.out.println(json);
        clients = readJSON(json);
        saveXML();
    }

    private static void readXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            clients = (Clients) unmarshaller.unmarshal(new File(XMLIN));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getJSON() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(clients);
    }

    private static Clients readJSON(String json){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.fromJson(json, Clients.class);
    }

    private static void saveXML(){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients, new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
