package by.it.dkruchek.jd02_09.TaskC;

class ConverterFactory<T> {

    Converter<T> getConverter(Direction direction, Class<T> cls){
        switch (direction){
            case JSON_TO_XML:
                return new ConverterJsonToXml<>(cls);
            case XML_TO_JSON:
                return new ConverterXmlToJson<>(cls);
            default:
                return null;
        }
    }
}
