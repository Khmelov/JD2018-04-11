package by.it.kashayed.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class Transfrm {
    public static void main(String[] args) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Source xsl = new StreamSource(new File("src/by/it/kashayed/jd02_08/trnsf.xsl"));
        Source xml = new StreamSource(new File("src/by/it/kashayed/jd02_07/Sales.xml"));
        Result html = new StreamResult("src/by/it/kashayed/jd02_08/Sales.html");
        try {
            Transformer transformer = tf.newTransformer(xsl);
            transformer.transform(xml,html);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
