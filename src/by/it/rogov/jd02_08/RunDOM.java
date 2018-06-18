package by.it.rogov.jd02_08;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class RunDOM {

    private static String xmlFile = "src/by/it/rogov/jd02_07/Users.xml";

    public static void main(String[] args) {

        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);



        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }



    public static void printElement(){

    }

}
