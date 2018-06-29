package by.it.shekh.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    private StringBuilder text = new StringBuilder();
    private String tab = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StringBuilder attrStr = new StringBuilder();
        for (int i = 0; i < attributes.getLength(); i++) {
            attrStr
                    .append(" ")
                    .append(attributes.getLocalName(i))
                    .append("=\"")
                    .append(attributes.getValue(i))
                    .append('"');

        }
        System.out.printf(tab + "<%s%s>\n", qName, attrStr.toString());
        tab = tab.concat("\t");

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String txt = text.toString().trim();
        if (txt.length() > 0) {
            System.out.println(tab + txt);
            text.setLength(0);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(new String(ch, start, length));
    }
}
