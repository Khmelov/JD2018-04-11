package by.it.zaliashchonak.jd02_08;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class RunnerTransform {

    public static void main(String[] args) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            String xslFile = "src/by/it/zaliashchonak/jd02_08/transform.xsl";
            Source xsl = new StreamSource(new File(xslFile));
            String input = "src/by/it/zaliashchonak/jd02_07/Client.xml";
            Source xml = new StreamSource(new File(input));
            String output = "src/by/it/zaliashchonak/jd02_08/Clients.html";
            Result html=new StreamResult(output);
            Transformer transformer = transformerFactory.newTransformer(xsl);
            transformer.transform(xml,html);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
