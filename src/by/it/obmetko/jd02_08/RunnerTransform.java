package by.it.obmetko.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class RunnerTransform {
    private static String xslFile = "src/by/it/obmetko/jd02_08/transform.xsl";
    private static String input = "src/by/it/obmetko/jd02_07/Persons.xml";
    private static String output = "src/by/it/obmetko/jd02_08/Persons.html";

    public static void main(String[] args) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Source xsl = new StreamSource(new File(xslFile));
            Source xml = new StreamSource(new File(input));
            Result html=new StreamResult(output);
            Transformer transformer = transformerFactory.newTransformer(xsl);
            transformer.transform(xml,html);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
