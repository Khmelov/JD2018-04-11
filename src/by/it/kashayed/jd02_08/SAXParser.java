package by.it.kashayed.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXParser extends DefaultHandler {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        String path = "src/by/it/kashayed/jd02_07/Sales_XSD.xml";
        try {
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            SAXParser myParser = new SAXParser();
            parser.parse(new File(path),myParser);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: "+e.toString());
        }
    }
    private String tab="";
    private String value;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало документа");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab+"["+qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String first = attributes.getLocalName(i);
            String second = attributes.getValue(i);
            System.out.println(" "+first+"=\""+second+"\"");
            System.out.print("\t");
        }
        System.out.println("]");
        tab='\t'+tab;
        value="";
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value=value
                .concat(new String (ch,start,length))
                .replace(" ","")
                .replace("\n","");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(!value.isEmpty()){
            System.out.println(tab+value);
        }
        value="";
        tab=tab.substring(1);
        System.out.println(tab+"[/"+qName+"]");
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец документа");

    }

}
