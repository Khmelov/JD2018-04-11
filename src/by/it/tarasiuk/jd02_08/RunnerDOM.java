package by.it.tarasiuk.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;

public class RunnerDOM {
    public static void main(String[] args) {
        String xmlFile = "src/by/it/tarasiuk/jd02_07/Sellers.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            Element element = document.getDocumentElement();
            printDom("", element);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String prefix, Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(prefix + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attr = node.getAttributes();
                for (int i = 0; i < attr.getLength(); i++) {
                    Node attribute = attr.item(i);
                    System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
                }
            }
            System.out.println(">");
            if (node.hasChildNodes()) {
                String content = node.getFirstChild().getTextContent().trim();
                if (!content.isEmpty())
                    System.out.println(prefix + "\t" + content);
            }
            prefix = prefix.concat("\t");
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                printDom(prefix, childNodes.item(i));
            }
            prefix = prefix.substring(1);
            System.out.println(prefix + "</" + node.getNodeName() + ">");
        }
    }
}

