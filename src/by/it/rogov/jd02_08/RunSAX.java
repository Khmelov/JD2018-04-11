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

    public static void main(String[] args) {

        String xmlFile="src/by/it/rogov/jd02_08/Clients+xsd.xml";
        SAXParserFactory saxParserFactory =SAXParserFactory.newInstance();
        try {
            SAXParser saxParser= saxParserFactory.newSAXParser();
            RunSAX runSAX= new RunSAX();
            saxParser.parse(new File(xmlFile),runSAX);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private String str;
    private String tab="";
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

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
}
