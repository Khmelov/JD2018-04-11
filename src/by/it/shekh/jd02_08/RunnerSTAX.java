package by.it.shekh.jd02_08;

import javax.xml.stream.*;
import java.io.*;

public class RunnerSTAX {
    private static String xmlFILE = "/src/by/it/shekh/jd02_07/Persons+xsd.xml";
    private static String tab = "";
    private static StringBuilder attrStr = new StringBuilder();


    public static void main(String[] args) {

        try (
                Reader reader =
                        new BufferedReader(
                                new FileReader(
                                        System.getProperty("user.dir") + xmlFILE))
        ) {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);


            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:

                        for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                            attrStr
                                    .append(" ")
                                    .append(xmlStreamReader.getAttributeLocalName(i))
                                    .append("=\"")
                                    .append(xmlStreamReader.getAttributeValue(i))
                                    .append('"');

                        }
                        System.out.printf(tab + "<%s%s>\n", xmlStreamReader.getLocalName(), attrStr.toString());
                        tab = tab.concat("\t");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        attrStr.append(xmlStreamReader.getTextCharacters());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        String txt = attrStr.toString().trim();
                        if (txt.length() > 0) {
                            System.out.println(tab + txt);
                            attrStr.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + xmlStreamReader.getLocalName() + ">");
                        break;

                }

            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }


    }
}
