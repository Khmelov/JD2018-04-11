package by.it.tarasiuk.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static final String XMLIn = "src/by/it/tarasiuk/jd02_09/Sellers+xsd.xml";
    private static final String XMLOut = "src/by/it/tarasiuk/jd02_09/Out_Sellers+xsd.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Sellers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Sellers sellers = (Sellers) unmarshaller.unmarshal(new File(XMLIn));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(sellers, System.out);
            marshaller.marshal(sellers, new File(XMLOut));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
