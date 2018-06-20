package by.it.tayanovskii.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RunnerStAX {

    private static String xmlFile = "src/by/it/tayanovskii/jd02_07/Readers+xsd.xml";

    private static StringBuilder text = new StringBuilder();
    private static String tab = "";

    public static void main(String[] args) {
        try (
                BufferedReader bufferedReader =
                        new BufferedReader(
                                new FileReader(xmlFile))
        ) {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory
                    .createXMLStreamReader(bufferedReader);
            //start StAX
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder strAtt = new StringBuilder();
                        int attributeCount = reader.getAttributeCount();
                        for (int i = 0; i < attributeCount; i++) {
                            strAtt
                                    .append(" ")
                                    .append(reader.getAttributeLocalName(i))
                                    .append("=\"")
                                    .append(reader.getAttributeValue(i))
                                    .append('"');
                        }
                        System.out.printf(tab + "<%s%s>\n",
                                reader.getLocalName(),
                                strAtt.toString());
                        tab = tab.concat("\t");

                        break;
                    case XMLStreamConstants.CHARACTERS:
                        text.append(reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        String value = text.toString().trim();
                        if (!value.isEmpty()) {
                            System.out.println(tab + value);
                            text.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
