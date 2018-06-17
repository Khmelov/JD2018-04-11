package by.it.rogov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class RunSAX extends DefaultHandler {

    private static String xmlFile = "src/by/it/rogov/jd02_07/Users.xml";
    private static String value;
    private static String tab = "";

    public static void main(String[] args) {


        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            RunSAX runSAX = new RunSAX();
            saxParser.parse(new File(xmlFile), runSAX);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            value = attributes.getValue(i);
            System.out.println(" " + name + "=" + value);
        }
        System.out.println("]");
        tab += "\t";
        value = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty()) {
            System.out.println(tab + value);
        }
        value = "";
        tab = tab.substring(1);
        System.out.println(tab + "[/" + qName + "]");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch, start, length).trim());
    }
}
