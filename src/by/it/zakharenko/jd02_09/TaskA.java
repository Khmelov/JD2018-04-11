package by.it.zakharenko.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static final String XML="src/by/it/zakharenko/jd02_09/Clients+xsd.xml";
    private static final String XMLOUT="src/by/it/zakharenko/jd02_09/out.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Clients clients = (Clients)unmarshaller.unmarshal(new File(XML));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients,System.out);
            marshaller.marshal(clients,new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
