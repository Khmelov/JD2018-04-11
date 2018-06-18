package by.it.obmetko.jd02_09;

import java.io.File;

public class Runner {
    public static void main(String[] args) {

        ConverterFactory cf = new ConverterFactory();
        AbstractConverter<Persons> converter = cf.getConverter(ConverterFactory.ConverterType.XML_TO_JSON);
        String xmlInputPath = System.getProperty("user.dir") + "/src/by/it/obmetko/jd02_09/Persons+xsd.xml";
        String jsonOutputPath = System.getProperty("user.dir") + "/src/by/it/obmetko/jd02_09/Persons+xsd.json";
        String xmlOutputPath = System.getProperty("user.dir") + "/src/by/it/obmetko/jd02_09/Persons+xsd.xml";
        File xmlSource = new File(xmlInputPath);
        File xmlTarget = new File(xmlOutputPath);
        File jsonTarget = new File(jsonOutputPath);
        converter.load(xmlSource);
        converter.convert();
        converter.save(jsonTarget);
        System.out.println(converter.getText());

        converter = cf.getConverter(ConverterFactory.ConverterType.JSON_TO_XML);
        converter.load(jsonTarget);
        converter.convert();
        converter.save(xmlTarget);
        System.out.println(converter.getText());
    }
}