package by.it.tarasiuk.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {
    private StringBuilder text;
    private StringBuilder txtBuffer;
    private String tab;

    @Override
    public void startDocument() throws SAXException {
        text = new StringBuilder();
        txtBuffer = new StringBuilder();
        tab = "";
        text.append("startDocument\n");
    }

    @Override
    public void endDocument() throws SAXException {
        text.append("endDocument");
        System.out.println(text.toString());
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text.append(tab).append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            text.append(" ").append(attributes.getLocalName(i))
                    .append("=\"").append(attributes.getValue(i))
                    .append("\"");
        }
        text.append(">\n");
        tab = tab.concat("\t");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String value = txtBuffer.toString().trim();
        if (!value.isEmpty()) text.append(tab).append(value).append("\n");
        txtBuffer.setLength(0);
        tab = tab.substring(1);
        text.append(tab).append("</").append(qName).append(">\n");
    }

    @Override
    public void characters(char[] chars, int start, int length) throws SAXException {
        String textPart = new String(chars, start, length);
        txtBuffer.append(textPart);
    }
}
