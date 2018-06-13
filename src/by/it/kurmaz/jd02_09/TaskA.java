package by.it.kurmaz.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TaskA {

    private static String file = "D:\\students\\kurmaz\\JD2018-04-11\\src\\by\\it\\kurmaz\\jd02_09\\Clients + xsd.xml";
    private static String file1 = "D:\\students\\kurmaz\\JD2018-04-11\\src\\by\\it\\kurmaz\\jd02_09\\ClientsNew.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Clients clients = (Clients) unmarshaller.unmarshal(new File(file));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients, System.out);
            Writer writer = new FileWriter(file1);
            marshaller.marshal(clients, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
