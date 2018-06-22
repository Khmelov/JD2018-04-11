package by.it.dkruchek.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    private static final String XML = "src/by/it/dkruchek/jd02_09/Persons_xsd.xml";

//    public static void main(String[] args) {
//        try {
//            JAXBContext context = JAXBContext.newInstance(Persons.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            Persons persons = (Persons) unmarshaller.unmarshal(new File(XML));
//            //System.out.println(persons);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(persons, System.out);
//            marshaller.marshal(persons, new File("src/by/it/dkruchek/jd02_09/Persons_out.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
}
