package by.it.kashayed.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static String XML="src/by/it/kashayed/jd02_09/SalesOut.xml";
    private static String XMLOUT="src/by/it/kashayed/jd02_09/MarshallOut.xml";

    static Owners owners;

    public static void main(String[] args) {
        readXML();
        getJson();
        readJson(getJson());
        saveXML();
    }
    private static void readXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Owners.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            owners =(Owners) unmarshaller.unmarshal(new File(XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getJson() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String sgson = gson.toJson(owners);
        return sgson;
    }
    private static void readJson(String xml) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        owners=gson.fromJson(xml,Owners.class);
    }

    private static void saveXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Owners.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(owners,new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }




}
