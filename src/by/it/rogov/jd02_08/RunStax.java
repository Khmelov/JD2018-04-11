package by.it.rogov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RunStax {
    private static String xmlFile = "src/by/it/rogov/jd02_07/Users.xml";
    private static String tab = "";
    private static String value = "";

    public static void main(String[] args) {


        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(
                             new FileInputStream(xmlFile))
        ) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(bufferedInputStream);

            while (streamReader.hasNext()) {
                int type = streamReader.next();
                switch (type){
                    case  XMLStreamReader.START_ELEMENT:
                        System.out.print(tab + "[" + streamReader.getLocalName());
                        for (int i = 0; i < streamReader.getAttributeCount(); i++) {
                            String name = streamReader.getAttributeLocalName(i);
                            value = streamReader.getAttributeValue(i);
                            System.out.println(" " + name + "=" + value);
                        }
                        System.out.println("]");
                        tab += "\t";
                        value = "";
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        value = value.concat(streamReader.getText().trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (!value.isEmpty()) {
                            System.out.println(tab + value);
                        }
                        value = "";
                        tab = tab.substring(1);
                        System.out.println(tab + "[/" + streamReader.getLocalName() + "]");
                        break;
                }

            }

        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
