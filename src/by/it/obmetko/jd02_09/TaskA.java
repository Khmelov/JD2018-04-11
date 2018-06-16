package by.it.obmetko.jd02_09;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            String xmlSource = System.getProperty("user.dir") + "/src/by/it/obmetko/jd02_09/Persons+xsd.xml";
            String xmlTarget = System.getProperty("user.dir") + "/src/by/it/obmetko/jd02_09/Persons+xsd.xml";

            Persons persons = (Persons) unmarshaller.unmarshal(new File(xmlSource));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons, System.out);

            try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(persons, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
