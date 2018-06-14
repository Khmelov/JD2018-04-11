package by.it.akhmelev.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TaskA {
    private static final String XML="src/by/it/akhmelev/jd02_09/Persons+xsd.xml";
    private static final String XMLOUT="src/by/it/akhmelev/jd02_09/out.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Persons persons = (Persons)unmarshaller.unmarshal(new File(XML));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons,System.out);
            marshaller.marshal(persons,new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
