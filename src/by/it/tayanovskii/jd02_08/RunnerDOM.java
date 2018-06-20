package by.it.tayanovskii.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunnerDOM {
    private static String xmlFile = "src/by/it/tayanovskii/jd02_07/Readers+xsd.xml";
    private static String tab = "";
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document parse = documentBuilder.parse(xmlFile);
            Element documentElement = parse.getDocumentElement();
            printDom(documentElement);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private static void printDom(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(tab + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes .getLength(); i++) {
                    Node attribute = attributes .item(i);
                    System.out.print(" " + attribute.getNodeName() + "=" + '"' + attribute.getNodeValue()+ '"');
                }
            }
            System.out.println(">");
        }
        if ((node.getNodeType() == Node.TEXT_NODE) && (!node.getNodeValue().trim().isEmpty()))
            System.out.println(tab + node.getNodeValue().trim());

        tab = tab + "\t";

        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            printDom(childNodes.item(i));
        }


        tab = tab.substring(1);

        if (node.getNodeType() == Node.ELEMENT_NODE)
            System.out.println(tab + "</" + node.getNodeName() + ">");
    }
}
