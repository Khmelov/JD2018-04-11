package by.it.mokhart.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunnerDOM {

    private static String xmlFile = "src/by/it/mokhart/jd02_07/Clients+xsd.xml";
    private static String tab = "";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            Element el = doc.getDocumentElement();
            printDom(el);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE)
            if (node.hasAttributes()) {
                System.out.print(tab + "<" + node.getNodeName());
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
                }
                System.out.println(">");
            } else System.out.println(tab + "<" + node.getNodeName() + ">");

        if ((node.getNodeType() == Node.TEXT_NODE) && (!node.getNodeValue().trim().isEmpty()))
            System.out.println(tab + node.getNodeValue().trim());
        tab = tab.concat("\t");

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(children.item(i));
        }
        tab = tab.substring(1);
        if (node.getNodeType() == Node.ELEMENT_NODE)
            System.out.println(tab + "</" + node.getNodeName() + ">");
    }
}
