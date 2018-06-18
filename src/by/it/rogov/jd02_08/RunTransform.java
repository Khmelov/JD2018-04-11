package by.it.rogov.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class RunTransform {

    private static String xslFile = "src/by/it/rogov/jd02_08/transform.xsl";
    private static String input = "src/by/it/rogov/jd02_07/Users.xml";
    private static String output = "src/by/it/rogov/jd02_08/output.html";

    public static void main(String[] args) {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Source xsl = new StreamSource(new File(xslFile));
        Source xml = new StreamSource(new File(input));
        Result html= new StreamResult(output);
        try {
            Transformer transformer = transformerFactory.newTransformer(xsl);
            transformer.transform(xml,html);
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }
}
