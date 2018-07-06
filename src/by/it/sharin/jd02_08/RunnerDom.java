package by.it.sharin.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunnerDom {
    private static String FileName = "src/by/it/sharin/jd02_07/Persons.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder  = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(FileName);
            Element root = document.getDocumentElement();
            PrintDom("", root);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static void PrintDom(String prefix, Node root){
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(prefix + "<" + root.getNodeName());
            if (root.hasAttributes()) {
                NamedNodeMap attr = root.getAttributes();
                for (int i = 0; i < attr.getLength(); i++) {
                    Node attribute = attr.item(i);
                    System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
                }
            }
            System.out.println(">");
            if (root.hasChildNodes()) {
                String content = root.getFirstChild().getTextContent().trim();
                if (!content.isEmpty())
                    System.out.println(prefix + "\t" + content);
            }
            prefix = prefix.concat("\t");
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                PrintDom(prefix, childNodes.item(i));
            }
            prefix = prefix.substring(1);
            System.out.println(prefix + "</" + root.getNodeName() + ">");
        }
    }
}
