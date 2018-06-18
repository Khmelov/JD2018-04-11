package by.it.tarasiuk.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.File;

public class RunnerTransform {
    private static String xslFile = "src/by/it/tarasiuk/jd02_08/Transform.xsl";
    private static String input = "src/by/it/tarasiuk/jd02_07/Sellers.xml";
    private static String output = "src/by/it/tarasiuk/jd02_08/Sellers.html";

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
