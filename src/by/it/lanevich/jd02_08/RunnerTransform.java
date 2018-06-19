package by.it.lanevich.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class RunnerTransform {
    private static String xslFile = "src/by/it/lanevich/jd02_08/transform.xsl";
    private static String input = "src/by/it/lanevich/jd02_07/Customers.xml";
    private static String output = "src/by/it/lanevich/jd02_08/Customers.html";

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
