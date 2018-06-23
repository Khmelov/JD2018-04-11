package by.it.tayanovskii.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static final String XML="src/by/it/tayanovskii/jd02_09/Readers+xsd.xml";
    private static final String XMLOUT="src/by/it/tayanovskii/jd02_09/Readers+xsd_out.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Readers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Readers persons = (Readers)unmarshaller.unmarshal(new File(XML));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons,System.out);
            marshaller.marshal(persons,new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
