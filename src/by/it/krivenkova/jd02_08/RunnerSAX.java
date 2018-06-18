package by.it.krivenkova.jd02_08;

import org.xml.sax.helpers.DefaultHandler;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class RunnerSAX {
    private static String xmlFile = "src/by/it/krivenkova/jd02_07/Users+xsd.xml";

    public static void main(String[] args) {
        try {
            DefaultHandler handler = new MyHandler();
            SAXParserFactory
                    .newInstance()
                    .newSAXParser()
                    .parse(new File(xmlFile), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
