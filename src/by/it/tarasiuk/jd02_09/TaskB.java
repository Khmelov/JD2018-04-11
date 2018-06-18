package by.it.tarasiuk.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {
    private static final String XMLIn = "src/by/it/tarasiuk/jd02_09/Out_Sellers+xsd.xml";
    private static final String XMLOut = "src/by/it/tarasiuk/jd02_09/resultB.xml";

    private static Sellers sellers;

    private static void readXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sellers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            sellers = (Sellers) unmarshaller.unmarshal(new File(XMLIn));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getJson() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        return gson.toJson(sellers);
    }

    private static void readJson(String json) {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        sellers = gson.fromJson(json, Sellers.class);
    }

    private static void saveXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sellers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(sellers, new File(XMLOut));
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

