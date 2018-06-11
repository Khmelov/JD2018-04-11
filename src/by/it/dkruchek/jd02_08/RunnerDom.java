package by.it.dkruchek.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunnerDom {
    private static String fileName = "src/by/it/dkruchek/JD02_07/Company.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder  = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            Element root = document.getDocumentElement();
            printDom(root);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }


    static void printDom(Node root){
        String value = root.getNodeValue();
        if (value != null){
            System.out.println(root.getNodeName());
        }
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            printDom(childNodes.item(i));
        }
    }
}
