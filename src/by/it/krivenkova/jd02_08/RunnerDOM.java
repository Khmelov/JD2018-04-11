package by.it.krivenkova.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunnerDOM {

    private static StringBuilder text = new StringBuilder();
    private static String tab = "";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlFile = "src/by/it/krivenkova/jd02_07/Users+xsd.xml";

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder reader = docFactory.newDocumentBuilder();
        Document doc = reader.parse(xmlFile);
        Element root = doc.getDocumentElement();
        showDOM(root);
    }

    //start DOM

    private static void showDOM(Node root) {
        if (root.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(tab + "<" + root.getNodeName());
            if (root.hasAttributes()) {
                NamedNodeMap attr = root.getAttributes();
                for (int i = 0; i < attr.getLength(); i++) {
                    Node attribute = attr.item(i);
                    System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
                }
            }
            System.out.println(">");
        }
        if ((root.getNodeType() == Node.TEXT_NODE) && (!root.getNodeValue().trim().isEmpty()))
            System.out.println(tab + root.getNodeValue().trim());

        tab = tab + "\t";

        NodeList child = root.getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            showDOM(child.item(i));
        }


        tab = tab.substring(1);

        if (root.getNodeType() == Node.ELEMENT_NODE)
            System.out.println(tab + "</" + root.getNodeName() + ">");


    }
}

