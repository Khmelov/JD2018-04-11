package by.it.shumilov.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class RunnerSAX {
    private static String xmlFile = "src/by/it/shumilov/jd02_08/Students_xsd.xml";

    public static void main(String[] args) throws IOException {



        {
            try {

                SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
                SAXParser saxParser = saxParserFactory.newSAXParser();
                DefaultHandler defaultHadler = new  MyHandler();
                saxParser.parse(new File(xmlFile), defaultHadler);

            } catch (ParserConfigurationException | SAXException e) {
                e.printStackTrace();
            }
        }
    }


}
