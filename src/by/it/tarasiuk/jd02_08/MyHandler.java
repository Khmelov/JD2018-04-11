package by.it.tarasiuk.jd02_08;

import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");

    }



    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        System.out.println("<"+qName+">");
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        System.out.println("\n</"+qName+">");

    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        System.out.println(new String(ch,start,length));
    }
    DefaultHandler

}
