package by.it.tarasiuk.jd02_08;

import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class RunnerSAX {
    private static String xmlFile = "src/by/it/tarasiuk/jd02_07/Persons+xsd.xml";

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            DefaultHandler handler = new DefaultHandler();
            saxParser.parse(new File(xmlFile), handler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
