package by.it.shekh.jd02_08;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class RunnerSAX {

    private static String xmlFILE = "/src/by/it/shekh/jd02_07/Persons+xsd.xml";

    public static void main(String[] args) {


        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler defaultHandler = new MyHandler();
            saxParser.parse(new File(System.getProperty("user.dir") + xmlFILE), defaultHandler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
