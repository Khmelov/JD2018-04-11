package by.it.lanevich.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunnerDOM {


    private static String tab = "";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        try{
            builder = factory.newDocumentBuilder();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        String FileName = "src/by/it/lanevich/jd02_07/CustomersXSD.xml";
        try{
            doc = builder.parse(FileName);
        }catch (SAXException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        Element root = doc.getDocumentElement();
        printDOM(root);
    }

    private static void printDOM(Node node) {

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(tab + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attr = node.getAttributes();
                for (int i = 0; i < attr.getLength(); i++) {
                    Node attribute = attr.item(i);
                    System.out.print(" "+attribute.getNodeName()+"=\""+attribute.getNodeValue()+"\"");
                }
            }
            System.out.println(">");
        }
        if ((node.getNodeType() == Node.TEXT_NODE) && (!node.getNodeValue().trim().isEmpty()))
            System.out.println(tab + node.getNodeValue().trim());

        tab = tab + "\t";

        NodeList child = node.getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            printDOM(child.item(i));
        }


        tab = tab.substring(1);

        if (node.getNodeType() == Node.ELEMENT_NODE)
            System.out.println(tab + "</" + node.getNodeName() + ">");


    }


}
