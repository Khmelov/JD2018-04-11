package by.it.kashayed.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    private static String XML="src/by/it/kashayed/jd02_09/Sales_XSD.xml";
    private static String XMLOUT="src/by/it/kashayed/jd02_09/SalesOut.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Owners.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Owners owners = (Owners)unmarshaller.unmarshal(new File(XML));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(owners, System.out);
            marshaller.marshal(owners, new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
