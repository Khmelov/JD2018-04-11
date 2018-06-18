package by.it.zaliashchonak.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RunnerStAX {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        String tab = "";
        StringBuilder text = new StringBuilder();
        String fileName = "src/by/it/zaliashchonak/jd02_07/Clients+xsd.xml";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlReader = xmlInputFactory.createXMLStreamReader(reader);
            while (xmlReader.hasNext()) {
                int type = xmlReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder att = new StringBuilder();
                        for (int i = 0; i < xmlReader.getAttributeCount(); i++) {
                            att.append(" ").append(xmlReader.getAttributeLocalName(i)).append(" = \"").append(xmlReader.getAttributeValue(i)).append("\"");
                        }
                        System.out.print(tab + "<" + xmlReader.getLocalName());
                        System.out.print(att.toString());
                        System.out.println(">");
                        tab = tab.concat("\t");
                        text.setLength(0);
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        String txt = text.toString().trim();
                        if (!txt.isEmpty()) {
                            System.out.println(tab + txt);
                            text.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + xmlReader.getLocalName()+ ">");
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        text.append(xmlReader.getText());
                        break;
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
