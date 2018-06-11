package by.it.shumilov.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class MyValidator {
    public static void main(String[] args) {
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fn="src/by/it/shumilov/jd02_07/Elective/Students_xsd.xml";
        String sh="src/by/it/shumilov/jd02_07/Elective/Schema.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            Schema schema = factory.newSchema(new File(sh));
            Validator validator = schema.newValidator();
            StreamSource streamSource = new StreamSource(fn);
            validator.validate(streamSource);
            System.out.println("OK");
        } catch (SAXException | IOException e) {
            System.out.println("not Ok");
            e.printStackTrace();
        }
    }
}
