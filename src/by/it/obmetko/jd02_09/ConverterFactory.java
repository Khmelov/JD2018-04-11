package by.it.obmetko.jd02_09;

public class ConverterFactory {
    public enum ConverterType {
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter<Persons> getConverter(ConverterType type) {
        switch (type) {
            case XML_TO_JSON:
                return new XmlToJsonConverter<>(Persons.class);
            case JSON_TO_XML:
                return new JsonToXmlConverter<>(Persons.class);
            default:
                return null;
        }
    }
}