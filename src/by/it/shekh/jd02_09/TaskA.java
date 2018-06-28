package by.it.shekh.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static String xml="D:\\Programming\\HTP_course\\JD2018-04-11\\src\\by\\it\\shekh\\jd02_09\\Persons+xsd.xml";
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Persons persons=(Persons)unmarshaller.unmarshal(new File(xml));
            System.out.println(persons);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
