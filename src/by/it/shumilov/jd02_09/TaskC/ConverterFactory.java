package by.it.shumilov.jd02_09.TaskC;

public class ConverterFactory {
    ConverterFactory(){}

    public Converter getConverter(Direction direction, Class<?> bean){
        Converter converter = null;

        switch (direction) {
            case JSON_TO_XML:
                converter = new ConverterJsonToXml(bean);
                break;
            case XML_TO_JSON:
                converter = new ConverterXmlToJson(bean);
                break;
        }
        return converter;
    }
}

