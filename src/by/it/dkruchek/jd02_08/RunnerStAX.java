package by.it.dkruchek.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class RunnerStAX {
    private static String fileName = "src/by/it/dkruchek/JD02_07/Company.xml";
    private static String tab = "";
    private static StringBuilder text = new StringBuilder();
    private static String value = "";

    public static void main(String[] args) {
        try(
            BufferedReader bufferedReader = new BufferedReader(
                                      new FileReader(fileName))){

            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(bufferedReader);

                while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                        StringBuilder strAtt = new StringBuilder();
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            strAtt.append(" ")
                                    .append(reader.getAttributeLocalName(i))
                                    .append("=\"")
                                    .append(reader.getAttributeValue(i))
                                    .append("\"");
                        }
                        System.out.printf(tab + "<%s%s>\n", reader.getLocalName(), strAtt.toString());
                        tab = tab.concat("\t");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        value = value.concat(reader.getText().trim());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (!value.isEmpty()) {
                            System.out.println(tab + value);
                        }
                        tab = tab.substring(1);
                        value = "";
                        System.out.println(tab + "</"+reader.getLocalName()+">");
                        break;
                }
            }

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }


    }
}
