package by.it.tarasiuk.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static void main(String[] args) {
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String xmlFile = "src/by/it/tarasiuk/jd02_07/Sellers+xsd.xml";
        String xsdFile = "src/by/it/tarasiuk/jd02_07/Sellers.xsd";
        SchemaFactory schemaFactory = SchemaFactory.newInstance(lang);
        File schemaLocation = new File(xsdFile);
        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            StreamSource streamSource = new StreamSource(xmlFile);
            validator.validate(streamSource);
            System.out.println(xmlFile + "- is valid.");
        } catch (SAXException | IOException e) {
            System.err.print(xmlFile + " - is invalid: "
                    + e.getMessage());
        }
    }
}
