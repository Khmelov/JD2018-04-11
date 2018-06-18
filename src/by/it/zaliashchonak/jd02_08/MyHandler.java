package by.it.zaliashchonak.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{

    private StringBuilder text = new StringBuilder();
    private String tab = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start doc");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End doc");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder att = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            att.append(" ").append(attributes.getLocalName(i)).append(" = \"").append(attributes.getValue(i)).append("\"");
        }
        System.out.print(tab + "<" + qName);
        System.out.print(att.toString());
        System.out.println(">");
        tab = tab.concat("\t");
        text.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String txt = text.toString().trim();
        if (!txt.isEmpty()) {
            System.out.println(tab + txt);
            text.setLength(0);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

}
