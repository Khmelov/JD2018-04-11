package by.it.rogov.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static final String XML = "src/by/it/rogov/jd02_09/Clients+xsd.xml";
    private static final String XMLOUT = "src/by/it/rogov/jd02_09/out.html";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(XML));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, System.out);
            marshaller.marshal(users, new File(XMLOUT));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
