package by.it.shumilov.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class RunnerTransform {
    private  static  String xslFile = "src/by/it/shumilov/jd02_08/transform.xml";
    private static String xmlFile = "src/by/it/shumilov/jd02_08/Students_xsd.xml";
    private static String outFile = "src/by/it/shumilov/jd02_08/Students.html";

    public static void main(String[] args) throws TransformerException {
        try {

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xsl = new StreamSource(new File(xslFile));
        Source xml = new StreamSource(new File(xmlFile));
        Result html = new StreamResult(outFile);
        Transformer transformer = tFactory.newTransformer(xsl);

        transformer.transform(xml,html);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

    }
}
