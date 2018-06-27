package by.it.kasiyanov.jd02_07.classWork;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fn = "src/by/it/kasiyanov/jd02_07/classWork/Pesons+XSD.xml";
        String sh = "src/by/it/kasiyanov/jd02_07/classWork/Schema.xsd";
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
