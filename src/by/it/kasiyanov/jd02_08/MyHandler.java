package by.it.kasiyanov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    private StringBuilder text = new StringBuilder();
    private String tab = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder strAtt = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            strAtt
                    .append(" ")
                    .append(attributes.getLocalName(i))
                    .append("=\"")
                    .append(attributes.getValue(i))
                    .append("\"");
        }
        System.out.printf(tab + "<%s%s>\n",qName,strAtt.toString());
        tab = tab.concat("\t");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String value = text.toString().trim();
        if (!value.isEmpty()) {
            System.out.println(tab + value);
            text.setLength(0);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }
}
