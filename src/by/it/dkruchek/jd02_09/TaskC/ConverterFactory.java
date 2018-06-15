package by.it.dkruchek.jd02_09.TaskC;

public class ConverterFactory {

    Converter getConverter(Direction direction){
        switch (direction){
            case JSON_TO_XML:
                return new ConverterJsonToXml();
            case XML_TO_JSON:
                return new ConverterXmlToJson();
            default:
                return null;
        }
    }
}
