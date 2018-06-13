package by.it.kurmaz.jd02_09;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TaskB {

    private static String XMLIN = "D:\\students\\kurmaz\\JD2018-04-11\\src\\by\\it\\kurmaz\\jd02_09\\Clients + xsd.xml";
    private static String XMLOUT = "D:\\students\\kurmaz\\JD2018-04-11\\src\\by\\it\\kurmaz\\jd02_09\\ClientsNew2.xml";
    private static Clients clients;


    void readXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            clients = (Clients) unmarshaller.unmarshal(new File(XMLIN));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    String getJSON(){
        return null;
    }

    Client readJSON(){
        return null;
    }

    void saveXML(){
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
