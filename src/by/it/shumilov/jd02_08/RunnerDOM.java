package by.it.shumilov.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunnerDOM {

    private static String xmlFile = "src/by/it/shumilov/jd02_08/Students_xsd.xml";

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            dBF.setIgnoringComments(true);
            dBF.setIgnoringElementContentWhitespace(true);
            dBF.setValidating(false);
            DocumentBuilder builder = dBF.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            Element element = document.getDocumentElement();

            printDOM("", element);

        } catch (ParserConfigurationException | SAXException | IOException e1) {
            e1.printStackTrace();
        }


    }

    private  static void printDOM(String tab, Node node){

        String value = node.getNodeValue();

        if(value != null){
            if(!value.contains("\n"))
                System.out.println(tab +  value.trim() );

        }
        else {
            StringBuilder attr = new StringBuilder(" ");

            NamedNodeMap attributes = node.getAttributes();

            for (int i = 0; i < attributes.getLength(); i++) {
                attr.append(attributes.item(i).getNodeName() + "=\"" +  attributes.item(i).getNodeValue() + "\" ");
            }
            attr.delete(attr.length()-1,attr.length());

            System.out.println(tab + "<" + node.getNodeName() + attr.toString() + ">");


            NodeList childList = node.getChildNodes();

            for (int i = 0; i < childList.getLength(); i++) {

                printDOM(tab + "\t", childList.item(i));
            }
            System.out.println(tab + "</" + node.getNodeName() + ">");
        }

    }
}

