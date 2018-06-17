package by.it.gavrilchik.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import java.io.File;

public class TaskA {

    private static String XML="src/by/it/gavrilchik/jd02_09/Persons+xsd.xml";
    private static String XMLOUT="src/by/it/gavrilchik/jd02_09/out.xml";
    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(new File(XML));
            //System.out.println(persons);
            Marshaller marshaller=jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(persons, System.out);
            marshaller.marshal(persons, new File(XMLOUT));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
