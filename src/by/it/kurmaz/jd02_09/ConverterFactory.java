package by.it.kurmaz.jd02_09;

class ConverterFactory {

    static Converter getConverter(Direction direction, Class beanClass) {
        switch (direction) {
            case JSON_TO_XML:
                return new JSONtoXMLConverter(beanClass);
            case XML_TO_JSON:
                return new XMLtoJSONConverter(beanClass);
        }
        return null;
    }
}
