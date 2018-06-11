package by.it.kashayed.jd02_07;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.File;
import java.io.IOException;

public class Vldtr {
    public static void main(String[] args) {
        String Language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String filename = "src/by/it/kashayed/jd02_07/Sales_XSD.xml";
        String  schemaName = "src/by/it/kashayed/jd02_07/schema.xsd";
        SchemaFactory sf = SchemaFactory.newInstance(Language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = sf.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println(filename+" validate");
        } catch (SAXException e) {
            e.printStackTrace();
            System.err.println("Валидация"+filename+" не выполнена"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(filename+" не валиден"+e.getMessage());

        }


    }
}
