package by.it.kashayed.jd02_08;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAXParser extends DefaultHandler {

    private static String tab = "";
    private static String value = "";

    public static void main(String[] args) {
        String path = "src/by/it/kashayed/jd02_07/Sales_XSD.xml";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader xSR = factory.createXMLStreamReader(fileInputStream);
            while (xSR.hasNext()) {
                int type = xSR.next();
                //System.out.println(type);
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.println(tab + "[" + xSR.getLocalName() + "]");
                        if(xSR.getAttributeCount()!=0){
                            System.out.println("\""+xSR.getNamespaceURI()+"\"");
                            System.out.println(xSR.getAttributePrefix(0)
                                    +"=\""+xSR.getAttributeNamespace(0)+"\"");
                            System.out.println(
                                    xSR.getAttributePrefix(0)
                                    +":"
                                    +xSR.getAttributeLocalName(0)
                                    +"=\""+xSR.getAttributeValue(0)+"\""
                            );
                        }
                        tab = "\t" + tab;
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        value = value
                                .concat(xSR
                                .getText()
                                .replace(" ", "")
                                .replace("\n", ""));
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!value.isEmpty()) {
                            System.out.println(tab + value);
                        }
                        value = "";
                        tab = tab.substring(1);
                        System.out.println(tab + "[/" + xSR.getLocalName() + "]");

                        break;
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.toString());
        }
    }

}
