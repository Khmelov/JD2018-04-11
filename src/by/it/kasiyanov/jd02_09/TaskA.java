package by.it.kasiyanov.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static final String XML = "src/by/it/kasiyanov/jd02_09/TravelAgents+XSD.xml";
    private static final String XMLOUT = "src/by/it/kasiyanov/jd02_09/out.xml";

    public static void main(String[] args) {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(TravelAgents.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            TravelAgents travelAgents = (TravelAgents) unmarshaller.unmarshal(new File(XML));
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(travelAgents, System.out);
            marshaller.marshal(travelAgents, new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
