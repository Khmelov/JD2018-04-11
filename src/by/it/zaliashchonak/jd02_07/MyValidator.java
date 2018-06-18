package by.it.zaliashchonak.jd02_07;


import javax.xml.XMLConstants;
import java.io.File;
import java.io.IOException;
import javax.xml.validation.SchemaFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import org.xml.sax.SAXException;



public class MyValidator {
    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fn="src/by/it/zaliashchonak/jd02_07/Clients+xsd.xml";
        String sh="src/by/it/zaliashchonak/jd02_07/Schema.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            Schema schema = factory.newSchema(new File(sh));
            javax.xml.validation.Validator validator = schema.newValidator();
            StreamSource streamSource = new StreamSource(fn);
            validator.validate(streamSource);
            System.out.println("OK");
        } catch (SAXException | IOException e) {
            System.out.println("not Ok");
            e.printStackTrace();
        }

    }
}