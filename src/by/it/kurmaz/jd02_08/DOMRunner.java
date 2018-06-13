package by.it.kurmaz.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class DOMRunner {

    private static Deque<String> nodeNames = new LinkedList<>();

    public static void main(String[] args) {
        String fileName = "src/by/it/kurmaz/jd02_07/Clients + xsd.xml";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);
            Element documentElement = document.getDocumentElement();
            printElement("", documentElement);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(String prefix, Node node) {
        short type = node.getNodeType();
        switch (type){
            case (Node.ELEMENT_NODE):
                nodeNames.add(node.getNodeName().trim());
                System.out.print(prefix + "<" + nodeNames.getLast());
                if (node.hasAttributes())
                    printAttributes(node);
                System.out.println(">");
                NodeList childNodes = node.getChildNodes();
                prefix = prefix.concat("\t");
                for (int i = 0; i < childNodes.getLength(); i++) {
                    printElement(prefix, childNodes.item(i));
                }
                System.out.println(prefix.substring(1) + "</" + nodeNames.pollLast() + ">");
                break;
            case (Node.TEXT_NODE):
                if (!(node.getNodeValue().trim()).equals("")) {
                    System.out.println(prefix + node.getNodeValue().trim());
                }
                break;
        }
    }

    private static void printAttributes(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node att = attributes.item(i);
            System.out.print(" " + att.getNodeName() + "=\"" + att.getNodeValue() + "\"");
        }
    }
}
