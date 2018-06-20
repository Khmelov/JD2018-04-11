package by.it.shumilov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class RunnerStAX {
    private static String xmlFile = "src/by/it/shumilov/jd02_08/Persons_xsd.xml";
    private static String tab = "";
    private static StringBuilder text = new StringBuilder();


    public static void main(String[] args) {
        try (Reader reader = new BufferedReader(new FileReader(xmlFile))){

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = xmlInputFactory.createXMLStreamReader(reader);

            //start StAX

            while (streamReader.hasNext()) {
                int next = streamReader.next();
                switch (next){
                    case XMLStreamConstants
                            .START_ELEMENT:
                        StringBuilder attr = new StringBuilder();
                        for (int i = 0; i <streamReader.getAttributeCount() ; i++) {
                            attr.append(" ")
                                    .append(streamReader.getAttributeLocalName(i))
                                    .append("=\"")
                                    .append(streamReader.getAttributeValue(i))
                                    .append('"');
                        }
                        System.out.printf(tab +String.format("<%s%s>\n" ,streamReader.getLocalName(),attr) );

                        tab = tab.concat("\t");
                        text.setLength(0);;break;
                    case XMLStreamConstants
                            .CHARACTERS:
                        text.append(streamReader.getText());break;
                    case XMLStreamConstants
                            .END_ELEMENT:
                        String txt = text.toString().trim();
                        if (!txt.isEmpty()){
                            System.out.println(tab + txt);
                            text.setLength(0);
                        }

                        tab = tab.substring(1);
                        System.out.println(tab + "</" + streamReader.getLocalName() + ">");;break;
                }
            }

        } catch (IOException  e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

//
//

    }
}
