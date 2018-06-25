package by.it.shumilov.jd02_09.TaskC;

import java.io.File;

public class Runner {

    private static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<Persons xmlns=\"http://TaskC.jd02_09.shumilov.it.by\">\n" +
            "    <Person>\n" +
            "        <Login>Vasya</Login>\n" +
            "        <Password>qwerty12345</Password>\n" +
            "        <Email>vasya12345@mail.ru</Email>\n" +
            "        <Ads>\n" +
            "            <Orders>\n" +
            "                <Description>\n" +
            "                    Шикарная квартира в самом центре за дорого!\n" +
            "                </Description>\n" +
            "                <Address>\n" +
            "                    ул. Ленина д.1 кв.13\n" +
            "                </Address>\n" +
            "                <Price currency=\"$$$$\">123456.0</Price>\n" +
            "                <Area>55.5</Area>\n" +
            "                <Floor>3</Floor>\n" +
            "                <Floors>5</Floors>\n" +
            "                <Rooms>2</Rooms>\n" +
            "            </Orders>\n" +
            "            <Orders>\n" +
            "                <Description>\n" +
            "                    Нешикарная квартира не в центре за дешево.\n" +
            "                </Description>\n" +
            "                <Address>\n" +
            "                    ул. Космическая д.3 кв.16\n" +
            "                </Address>\n" +
            "                <Price currency=\"EU\">44444.0</Price>\n" +
            "                <Area>44.4</Area>\n" +
            "                <Floor>4</Floor>\n" +
            "                <Floors>4</Floors>\n" +
            "                <Rooms>2</Rooms>\n" +
            "            </Orders>\n" +
            "        </Ads>\n" +
            "    </Person>\n" +
            "    <Person>\n" +
            "        <Login>Fedya</Login>\n" +
            "        <Password>asdfg12345</Password>\n" +
            "        <Email>fedya12345@mail.ru</Email>\n" +
            "        <Ads>\n" +
            "            <Orders>\n" +
            "                <Description>\n" +
            "                    Однокомнатная квартира!\n" +
            "                </Description>\n" +
            "                <Address>\n" +
            "                    ул. Ленина д.1 кв.1.\n" +
            "                </Address>\n" +
            "                <Price currency=\"BYN\">999999.0</Price>\n" +
            "                <Area>55.5</Area>\n" +
            "                <Floor>1</Floor>\n" +
            "                <Floors>5</Floors>\n" +
            "                <Rooms>1</Rooms>\n" +
            "            </Orders>\n" +
            "        </Ads>\n" +
            "    </Person>\n" +
            "</Persons>";

    private static String json = "{\n" +
            "  \"person\": [\n" +
            "    {\n" +
            "      \"login\": \"Vasya\",\n" +
            "      \"password\": \"qwerty12345\",\n" +
            "      \"email\": \"vasya12345@mail.ru\",\n" +
            "      \"ads\": {\n" +
            "        \"ad\": [\n" +
            "          {\n" +
            "            \"description\": \"\\n                    Шикарная квартира в самом центре за дорого!\\n                \",\n" +
            "            \"address\": \"\\n                    ул. Ленина д.1 кв.13\\n                \",\n" +
            "            \"price\": {\n" +
            "              \"value\": 123456.0,\n" +
            "              \"currency\": \"$$$$\"\n" +
            "            },\n" +
            "            \"area\": 55.5,\n" +
            "            \"floor\": 3,\n" +
            "            \"floors\": 5,\n" +
            "            \"rooms\": 2\n" +
            "          },\n" +
            "          {\n" +
            "            \"description\": \"\\n                    Нешикарная квартира не в центре за дешево.\\n                \",\n" +
            "            \"address\": \"\\n                    ул. Космическая д.3 кв.16\\n                \",\n" +
            "            \"price\": {\n" +
            "              \"value\": 44444.0,\n" +
            "              \"currency\": \"EU\"\n" +
            "            },\n" +
            "            \"area\": 44.4,\n" +
            "            \"floor\": 4,\n" +
            "            \"floors\": 4,\n" +
            "            \"rooms\": 2\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"login\": \"Fedya\",\n" +
            "      \"password\": \"asdfg12345\",\n" +
            "      \"email\": \"fedya12345@mail.ru\",\n" +
            "      \"ads\": {\n" +
            "        \"ad\": [\n" +
            "          {\n" +
            "            \"description\": \"\\n                    Однокомнатная квартира!\\n                \",\n" +
            "            \"address\": \"\\n                    ул. Ленина д.1 кв.1.\\n                \",\n" +
            "            \"price\": {\n" +
            "              \"value\": 999999.0,\n" +
            "              \"currency\": \"BYN\"\n" +
            "            },\n" +
            "            \"area\": 55.5,\n" +
            "            \"floor\": 1,\n" +
            "            \"floors\": 5,\n" +
            "            \"rooms\": 1\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private  static String fJson = "src/by/it/shumilov/jd02_09/TaskC/Persons.json";
    private  static String fXml = "src/by/it/shumilov/jd02_09/TaskC/Persons_xsd.xml";
    private  static String outXml = "src/by/it/shumilov/jd02_09/TaskC/Out.xml";

    public static void main(String[] args) {
        ConverterFactory cf =new ConverterFactory();

        Converter xmlToJson = cf.getConverter(Direction.XML_TO_JSON, Persons.class);
        xmlToJson.load(new File(fXml));



        System.out.println(xmlToJson.getText());
        xmlToJson.save(new File(fJson));

        Converter jsonToXml = cf.getConverter(Direction.JSON_TO_XML, Persons.class);
        jsonToXml.load(new File(fJson));

        System.out.println(jsonToXml.getText());
        jsonToXml.save(new File(outXml));


        Converter xmlToJson1 = cf.getConverter(Direction.XML_TO_JSON, Persons.class);
        xmlToJson1.load(xml);
        System.out.println(xmlToJson1.getText());

        Converter jsonToXml1 = cf.getConverter(Direction.JSON_TO_XML, Persons.class);
        jsonToXml1.load(json);
        System.out.println(jsonToXml1.getText());

    }

}
